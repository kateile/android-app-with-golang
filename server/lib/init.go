package lib

import "github.com/gin-gonic/gin"

func StartServer(port string) string {
	r := gin.Default()

	//Wildcard for handling all Get requests
	r.GET("/*anything", func(c *gin.Context) {
		c.JSON(200, gin.H{
			"message": "It's working dude!!!!!!",
		})
	})
	err := r.Run(":" + port) // listen and serve on 0.0.0.0:9090 (for windows "localhost:9090")

	if err != nil {
		panic("some error occurred: " + err.Error())
	}

	return port
}
