# What is this?

Just Experiment for using golang in android app.

# Usage

## Generating aar

Run

```bash
cd server
go install

go get -d golang.org/x/mobile/cmd/gomobile
gomobile bind -v -o ../client/app/libs/server.aar -target=android ./lib
```

# App Screenshots

When the first button is pressed, it generates random string via go bindings


<img src="/screenshots/1.png" alt="Screenshot 1" style="height: 500px; width:250px;"/>

<img src="/screenshots/2.png" alt="Screenshot 2" style="height: 500px; width:250px;"/>