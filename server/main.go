package main

import "gin/lib"

func main() {
	//listen and serve on 0.0.0.0:9090 (for windows "localhost:9090")
	lib.StartServer("9090", "db.db")
}
