package lib_test

import (
	"gin/lib"
	"testing"
)

func TestInit(t *testing.T) {
	t.Run("RandomString", func(t *testing.T) {
		length := 32

		str := lib.RandomString(length)

		if len(str) != length {
			t.Errorf("not equal to 32")
		}
	})
}
