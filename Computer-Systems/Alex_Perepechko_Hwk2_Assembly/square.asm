MODEL SMALL
STACK 100H

DATASEG
	
	msg 		db			'Enter a number: ', '$'
	msg2		db			'The square root is: ', '$'
	nextLine    db           0dh,0ah,'$' ;specify carriageReturn an LineFeed to move to next line


CODESEG
Start:
	mov ax,@data
	mov ds,ax
 
	mov dx, offset msg
	mov ah, 9;display the msg
	int 21h
	
	mov ah, 01h ;accept first character input
	int 21h
	;mov dl, al ;move first character to dl
	mov cl, 0AH
	sub al, 30H
	mul cl ;product is in ax
	mov dl, al
	
	mov ah, 01h ;accept second character input
	int 21h
	mov bl, al ;move second character to bl
	sub bl, 30H
	
	add dl, bl
	
mov cl, 1
mov al, 1
;sub cl, 30H
repeating:	
	cmp al, dl ;compare al to dl
	jg square ; if al > dl, jump to square label
	mov al, cl ; al = cl
	mul cl ; al = cl x al
	inc cl ; cl++
	jmp repeating ;loop
	
square:

	mov ah,09h ;show value on console
    lea dx,nextLine ; move nextLine to dx as a pointer
    int 21h
	
	mov ah,09h ;show value on console
    lea dx,msg2 ; display message in dx
    int 21h
	
	mov dl, cl ; move the value of cl into dl
	add dl, 30H ;add ascii value of 0 to get number
	sub dl, 2 ;gets you the correct number
	
	mov ah, 02h ;output character
	int 21h
	
	mov ah, 4ch ;exit dos
	int 21h
end Start