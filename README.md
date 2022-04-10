# What is this?

Just Experiment for using golang in android app.

# Usage

## Generating aar

Run

```bash
cd server
go get -d golang.org/x/mobile/cmd/gomobile
gomobile bind -v -o ../client/app/libs/server.aar -target=android ./lib
```

# App Screenshots

When the first button is pressed, it generates random string via go bindings

![Showing android screenshot 1!](/screenshots/1.png)
![Showing android screenshot 2!](/screenshots/2.png)