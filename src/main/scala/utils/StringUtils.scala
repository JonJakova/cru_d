package utils.StringUtils

def is_blank(str: String): Boolean =
  is_empty(str) match
    case true => true
    case false => is_whitespace(str)

def is_empty(s: String): Boolean =
  s match
    case "" => true
    case _ => false

def is_whitespace(str: String): Boolean =
  str.filter(_.isWhitespace).length == str.length
