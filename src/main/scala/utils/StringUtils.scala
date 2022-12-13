package utils.StringUtils

def is_blank(str: String): Boolean =
  var i = -1
  def check(char: String): Boolean = char == " "
  i = i+1
  if is_empty(str) then true else check( str.substring(i) )

def is_empty(s: String): Boolean =
  s match
    case "" => true
    case _ => false