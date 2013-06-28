package peal.synthesis

trait TopSet {

  def synthesis: String

  def z3SMTHeader: String

  def phiZ3SMTString = "(assert " + synthesis + ")\n(check-sat)"
}
