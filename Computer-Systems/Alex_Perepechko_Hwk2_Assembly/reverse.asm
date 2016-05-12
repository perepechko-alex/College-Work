MODEL small
STACK 100H

DATASEG
        stringname    db       100 dup(?), '$' ;duplicate string
        reverse       db       100 dup(?), '$'
        nextLine      db       0dh,0ah,'$' ;specify carriageReturn an LineFeed to move to next line
		msg			  db	   'Please enter a string: ','$'
CODESEG
Start: ;main procedure
        mov ax,@data
        mov ds,ax
        lea si,stringname ;load pointer of string
        lea di,reverse ; load pointer of string
		
		mov dx, offset msg
		
		mov ah, 9
		int 21h
		
        mov ah,01h ;input a character
repeating: ;continuously checks for input until the enter key is hit -- user stops providing input
        int 21h ;allows for user to provide continuous input
        cmp al,0dh ;compares the input to the carriage return (if the user hit enter)
        je  getstring ;jump to function when user hits enter

        mov [si],al ;writes contents of al to memory address specified by register si
        inc si ;increment si
        jmp repeating ;repeat until cmp al, 0dh is true, which will then jump to next function
getstring:
        mov al,'$' ;store current address of string, whatever it is (stringname in this case)
        mov [si],al ;store address of current string al into memory address of si

        mov ah,09h ;show value on console
        lea dx,nextLine ; move nextLine to dx as a pointer
        int 21h

        mov cx, si ; store the length of input into cx
        ;add cx,1 ;add 1 to the counter/length in order to not go out of bounds
getreverse:
		;start at the end of the string and start reversing to get backward string
        dec si ;decrement si
        mov al,[si] ;move the char input to al (last character, starting from end of input string)
        mov [di],al ; move the string from al to the address of di
        inc di ;increment di
        loop getreverse ;loop this function for each letter

        mov al,'$' ;store current string address in al; in this case, the reverse string
        mov [di],al ;move the reverse string to the memory address of di

        mov ah,09h
        ;lea dx,nextLine ;store pointer from nl to dx
        ;int 21h
        lea dx,reverse ; store pointer to reverse in dx
        int 21h

        mov ah,4ch ; return to DOS input
        int 21h
end Start