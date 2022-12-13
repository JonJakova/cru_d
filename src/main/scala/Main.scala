import scala.io.Source
import utils.StringUtils
import utils.GeneralUtils

@main def main(file_path: String, query: String, options: String*): Unit =
  val ignore_case = detach_args(options)
  Source.fromFile(file_path)
    .getLines()
    .filter(line => !StringUtils.is_blank(line))
    .filter(line => line_contains(line, query, ignore_case))
    .foreach(println)

def line_contains(line: String, query: String, ignore_case: Boolean): Boolean =
  if ignore_case then line.toLowerCase.contains(query.toLowerCase)
  else line.contains(query)

def detach_args(args: Seq[String]): Boolean = GeneralUtils.is_some(args.find(arg => arg == "--ignore-case"))