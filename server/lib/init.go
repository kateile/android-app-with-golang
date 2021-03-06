package lib

import (
	"crypto/rand"
	"encoding/base64"
	"fmt"
	"github.com/gin-gonic/gin"
	"gorm.io/driver/sqlite"
	"gorm.io/gorm"
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

type Product struct {
	gorm.Model
	Code  string
	Price uint
}

func StartServer(port string, dsn string) string {
	/**
	DB Configuration
	*/
	db, err := gorm.Open(sqlite.Open(dsn), &gorm.Config{})
	if err != nil {
		panic("failed to connect database")
	}

	// Migrate the schema
	err = db.AutoMigrate(&Product{})
	if err != nil {
		panic("failed to connect database")
	}

	db.Create(&Product{Code: "D42", Price: 100})

	/**
	Gin configuration
	*/
	r := gin.Default()

	//Wildcard for handling all Get requests
	r.GET("/*anything", func(c *gin.Context) {
		c.JSON(200, gin.H{
			"message": "It's working dude!!!!!!",
		})
	})

	go func() {
		err := r.Run(":" + port) // listen and serve on 0.0.0.0:9090 (for windows "localhost:9090")
		if err != nil {
			fmt.Println("the server run is error: " + err.Error())
		}
	}()

	return port
}
