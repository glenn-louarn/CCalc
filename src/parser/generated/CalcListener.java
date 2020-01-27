// Generated from /home/adrien/IMT/semestre-6/languages_de_programmation/CCalc/src/parser/Calc.g4 by ANTLR 4.8
package parser.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcParser}.
 */
public interface CalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalcParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CalcParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CalcParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(CalcParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(CalcParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#head}.
	 * @param ctx the parse tree
	 */
	void enterHead(CalcParser.HeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#head}.
	 * @param ctx the parse tree
	 */
	void exitHead(CalcParser.HeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(CalcParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(CalcParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(CalcParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(CalcParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntLit}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntLit(CalcParser.IntLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntLit}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntLit(CalcParser.IntLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVar(CalcParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVar(CalcParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MinusExp}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMinusExp(CalcParser.MinusExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MinusExp}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMinusExp(CalcParser.MinusExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinExp}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinExp(CalcParser.BinExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinExp}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinExp(CalcParser.BinExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondExp}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCondExp(CalcParser.CondExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondExp}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCondExp(CalcParser.CondExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunCall}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunCall(CalcParser.FunCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunCall}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunCall(CalcParser.FunCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#variableId}.
	 * @param ctx the parse tree
	 */
	void enterVariableId(CalcParser.VariableIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#variableId}.
	 * @param ctx the parse tree
	 */
	void exitVariableId(CalcParser.VariableIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#functionId}.
	 * @param ctx the parse tree
	 */
	void enterFunctionId(CalcParser.FunctionIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#functionId}.
	 * @param ctx the parse tree
	 */
	void exitFunctionId(CalcParser.FunctionIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#tail}.
	 * @param ctx the parse tree
	 */
	void enterTail(CalcParser.TailContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#tail}.
	 * @param ctx the parse tree
	 */
	void exitTail(CalcParser.TailContext ctx);
}