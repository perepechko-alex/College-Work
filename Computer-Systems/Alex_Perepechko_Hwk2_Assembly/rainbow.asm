; hex    bin        color
;
; 0      0000      black
; 1      0001      blue
; 2      0010      green
; 3      0011      cyan
; 4      0100      red
; 5      0101      magenta
; 6      0110      brown
; 7      0111      light gray
; 8      1000      dark gray
; 9      1001      light blue
; a      1010      light green
; b      1011      light cyan
; c      1100      light red
; d      1101      light magenta
; e      1110      yellow
; f      1111      white
MODEL LARGE
IDEAL
STACK 100H
org 100h

CODESEG
Start:

;initiate video
mov ax, 3
;mov ds, ax	
int 10h

;enable 16 colors
mov ax, 1003h
mov bx, 0 ;disable blinking
int 10h

;segment register:
mov		ax, 0b800h
mov		ds, ax

;print my name!

mov [02h], 'A'
mov [06h], 'l'
mov [0ah], 'e'
mov [0eh], 'x'

;color characters
mov di, 03h

mov[di], 2
add di,4

mov[di], 6
add di,4

mov[di], 7
add di,4

mov[di], 3
add di, 2
	
mov ah, 4Ch
int 21h

ret
End Start