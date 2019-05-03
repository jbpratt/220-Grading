package main

import (
	"fmt"
	"log"
	"os"
	"os/exec"
)

func main() {
	c, err := exec_c("java", "Assignments/Solutions/test1.java")
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println(c)
}

func exec_c(program string, args ...string) (*exec.Cmd, error) {
	cmd := exec.Command(program, args...)
	cmd.Stdin = os.Stdin
	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr
	err := cmd.Run()
	if err != nil {
		return nil, err
	}
	return cmd, nil
}
