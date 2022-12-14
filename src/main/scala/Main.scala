import scala.io.Source
import utils.StringUtils
import utils.GeneralUtils
import scala.util.Using

@main def main(file_path: String, query: String, options: String*): Unit =
  val (ignore_case, exclusive) = detach_args(options)
  Using(Source.fromFile(file_path)) { source =>
    source.getLines()
      .filter(line => !StringUtils.is_blank(line))
      .filter(line => if exclusive then !line_contains(line, query, ignore_case) else line_contains(line, query, ignore_case))
      .foreach(println)
  }

def line_contains(line: String, query: String, ignore_case: Boolean): Boolean =
  if ignore_case then line.toLowerCase.contains(query.toLowerCase)
  else line.contains(query)

def detach_args(args: Seq[String]): (Boolean, Boolean) =
  val cases = GeneralUtils.is_some(args.find(arg => arg == "--ignore-case"))
  val exclusive = GeneralUtils.is_some(args.find(arg => arg == "--exclusive"))
  (cases, exclusive)