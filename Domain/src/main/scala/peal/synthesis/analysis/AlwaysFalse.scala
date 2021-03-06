package peal.synthesis.analysis

case class AlwaysFalse(name: String, cond: String) extends AnalysisGenerator {

  def z3SMTInput: String = "(declare-const always_false_" + name + " Bool)\n" +
    "(assert (= always_false_" + name + " " + cond + "))\n" +
    "(assert always_false_" + name + ")\n" +
    "(check-sat)\n" +
    "(get-model)\n"

  def analysisName: String = name + " = always_false? " + cond
}
