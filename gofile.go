package main

import(
	"fmt"
	"unicode"
	"os"
	"io/ioutil"
)
func main(){
	stuff := readFile()
	stuff = parse(stuff)
	Write(stuff)
}
func readFile() string{
	fn := os.Args[1]
	stuff, err := ioutil.ReadFile(fn)
	Error(err)
	return(string(stuff))
}
func parse(stuff string) string{
	temp := ""
	for _,i := range stuff{
		if !unicode.IsNumber(i){
			temp = temp + string(i)
		}
	}
	return(temp)
}
func Write(stuff string) {
	var fn string
	fmt.Println("name of the output file? ")
	fmt.Scan(&fn)
	
	file,err := os.Create(fn)
	Error(err)
	file.WriteString(stuff)
}
func Error(e error){
	if e != nil {
		panic(e)
	}
}
