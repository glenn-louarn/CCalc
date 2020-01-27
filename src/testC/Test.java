package testC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.OptionalInt;
import java.util.Scanner;

import calc.Calc;

/** 
 * @author  Jacques Noye
 * @version 1.4
 * @since   2020-01-26
 */
public abstract class Test {
	static int count = 0;
	static int success = 0;
	static boolean verbose = false;

	public static void main(String[] args) {
		verbose = args.length > 0 && args[0].equals("-v");
	}

	public static void report(){
		System.out.println(success + " successful tests out of " + count);
	}
	// assumes the path environment variable has been updated so that bash (and gcc) is in the path	
	static final String SHELL = "bash";
	static final String EXT = ".out"; // EXT = ".exe"
	static final String CC = "gcc -Werror -Weverything"; // clang on macOS
	// static final String CC = "gcc -Werror" // gcc on Windows and Linux
	// static final String CC = "gcc-mp-8 -Werror"; // genuine gcc on macOS (if installed)
	/**
	 * Executes a test.
	 * 
	 * @param verbose	Verbose mode. Assumes compiler also has a verbose mode (option "-v" as
	 * 					second argument). 
	 * @param fileName  Name of file to compile (relative to project root).
	 * @param test		Description of the test.
	 * @param expectation	Expected result (as a string).
	 */
	public static void test(boolean verbose, String fileName, String test, OptionalInt expectation){
		count++;
/*		String[] args0;
		if (verbose) {
			args0 = new String[2];
			args0[1] = "-v";
		} else 
		args0 = new String[1];
		args0[0] = fileName;
		if (verbose) args0[1] = "-v";
 */
		System.out.println("==== " + fileName + ": " + test + ", attendu : " + expectation);
		try {
			long time0 = 0;
			long time1 = 0;
			String root = fileName.replaceFirst("\\.calc\\z", "");
			String cFileName = root + ".c";
			File cFile = new File(cFileName);
			if (cFile.exists()) 
			    time0 = cFile.lastModified();
			try {
			    Calc.compile(new FileInputStream(fileName), fileName);
			} catch(Exception e){
                System.err.println("==== Exception in compiler");
                e.printStackTrace();
			    if (expectation.isEmpty()) {
                    System.out.println("SUCCESS of " + root);
			        success++;
                } else
                    System.err.println("FAILURE of " + root);
			    return;
			}			
			if (cFile.exists()) // it should
			    time1 = cFile.lastModified();
			if (time1 > time0) { // some C code has been produced by the compiler 
			    // compile file
			    String outFileName = compile(cFileName);
			    File outFile = new File(outFileName);
			    if (outFile.exists()) {
				long time2 = outFile.lastModified();
				if (time2 >= time1) {
				    execute(outFileName);
				    String result = display(root + ".txt");
				    if (expectation.isPresent() && expectation.getAsInt() == Integer.parseInt(result)) {
					System.out.println("SUCCESS of " + root);
					success++;
				    } else System.err.println("FAILURE of " + root + " with " + result);
				} else 
				    System.err.println("FAILURE: C code for " + root + " does not compile");
			    } else 
				System.err.println("FAILURE: C code for " + root + " does not compile");
			} else { // no C code produced
			    System.err.println("No C code produced for " + fileName);
			    if (expectation.isEmpty()) {
			    	success++;
					System.out.println("SUCCESS of " + root);
				} else
					System.err.println("FAILURE of " + root);
		     }
		} catch(Exception e){
		    System.err.println("==== Unexpected exception");
		    e.printStackTrace();
		}
	}
			
	/**
	 * Compiles input file.
	 * 
	 * @param cFileName Name of input .c file. 
	 * @return Name of output executable (.out) file.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	static String compile(String cFileName) throws IOException, InterruptedException {
//		String[] cmd = new String[3];
//		cmd[0] = "/bin/sh";
//		cmd[1] = "-c";
//		cmd[2] = "/usr/bin/gcc " + CFilename;
		String outputFileName = cFileName.replaceFirst("\\.c\\z", EXT);
		String[] cmd = {SHELL, "-c", CC + " -o " + outputFileName + " " + cFileName};
		Runtime.getRuntime().exec(cmd).waitFor();
		return outputFileName;
	}

	/** 
	 * Executes input file and logs result in .txt file.
	 * 
	 * @param fileName		Input executable (.out) file.	
	 * @throws IOException
	 * @throws InterruptedException
	 */
	static void execute(String fileName) throws IOException, InterruptedException {
		String txtFileName = fileName.replaceFirst("\\" + EXT + "\\z", ".txt");
		String[] cmd = {SHELL, "-c", "./" + fileName + ">" + txtFileName};
		Runtime.getRuntime().exec(cmd).waitFor();
	}

	/**
	 * Reads result from .txt file. 
	 * 
	 * Assumes one-line result.
	 * 
	 * @param txtFileName Input .txt file.
	 * @return Contents of .txt as a string (first line only).			
	 * @throws FileNotFoundException
	 */
	static String display(String txtFileName) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(txtFileName));
		String result = scan.nextLine(); // assumes the result is on one line
		scan.close();
		new File("result").delete();
        return result;
	}
    
	/**
	 * For testing purposes.
	 * 
	 * @param shellCmd
	 * @throws IOException
	 * @throws InterruptedException
	 */
	static void test(String shellCmd) throws IOException, InterruptedException {
		String[] cmd = {SHELL, "-c", shellCmd};
		Runtime.getRuntime().exec(cmd).waitFor();
	}
}
