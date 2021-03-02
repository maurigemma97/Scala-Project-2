object Task2 {
	def main(args:Array[String]) {
		// Task 2a
		val url1 = io.Source.fromURL("https://www.bing.com")("ISO-8859-1").mkString
		val url2 = io.Source.fromURL("https://www.bgsu.edu").mkString
		println("Please enter the URL of a website to be searched: ")
		val x = scala.io.StdIn.readLine()
		var url=""
		try{
			url = io.Source.fromURL(x)("ISO-8859-1").mkString
		}
		catch{
				case e:Exception=>println("Exception! URl doesn't match")
		}
		val imgRegex = "<img.+?src=\"(.+?)\".*>".r
		val scriptRegex = "<script.*</script>".r
		var imageNum=0
		var scriptNum=0
		try{
				imageNum = imgRegex.findAllIn(url).matchData.toList.size
				println("We got images: " + imageNum)
				imageNum
 			}
 		catch{
 				case e:Exception=>0
 		}
 		
		try{
				scriptNum = scriptRegex.findAllIn(url).matchData.toList.size
				println("We got scripts: " +  scriptNum)
				scriptNum
 			}
 		catch{
 				case e:Exception=>0
 		}

		// Task 2b,2c,2d

		val linkRegex = "(?i)<a.+?href=\"(http.+?)\".*?>(.+?)</a>".r
		val linkList = linkRegex.findAllIn(url).matchData.toList.map(_.group(1))
		var imgNum = 0
		var imgMoreThan2Num = 0
		linkList.par.map {
			link =>
			try {
				val url = io.Source.fromURL(link).mkString
				val count = imgRegex.findAllIn(url).matchData.toList.size
				if (count > 2) {
					this.synchronized {imgMoreThan2Num += 1}
				}
				this.synchronized {imgNum += count}
				count
			}
			catch {
				case e:Exception => 0
			}
		}
		println("images in linked webpages: " + imgNum)
		println("linked webpages with more than 2 images : " + imgMoreThan2Num)
		println()
	}
}


