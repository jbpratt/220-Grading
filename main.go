package main

import (
	"log"
	"os"
	"os/exec"
)

func main() {
	exec_c("java", "Assignments/Solutions/test1.java")
}

func exec_c(program string, args ...string) {
	cmd := exec.Command(program, args...)
	cmd.Stdin = os.Stdin
	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr
	err := cmd.Run()
	if err != nil {
		log.Fatal(err)
	}
}
