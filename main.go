package main

import (
	"fmt"
	"log"
	"os/exec"
)

func main() {
	cmd := exec.Command("./main")
	stdin, err := cmd.StdinPipe()
	if err != nil {
		log.Fatal(err)
	}
	stdout, _ := cmd.StdoutPipe()
	cmd.Start()

	stdin.Write([]byte("meme\n"))
	out := make([]byte, 1024)
	n, _ := stdout.Read(out)

	fmt.Println("out:", string(out[:n]))
}
