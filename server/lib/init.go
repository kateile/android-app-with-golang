package lib

import (
	"crypto/rand"
	"encoding/base64"
	"github.com/gin-gonic/gin"
	"math"
)

func RandomString(l int) string {
	buff := make([]byte, int(math.Ceil(float64(l)/1.33333333333)))
	_, err := rand.Read(buff)
	if err != nil {
		return ""
	}
	str := base64.RawURLEncoding.EncodeToString(buff)
	return str[:l] // strip 1 extra character we get from odd length results
}

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
