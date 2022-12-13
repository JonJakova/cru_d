package utils.GeneralUtils

def is_some(opt: Option[_]): Boolean =
  opt match
    case Some(_) => true
    case None => false