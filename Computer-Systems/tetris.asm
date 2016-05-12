assume cs:code,ds:code,es:nothing
code segment

start:
	mov	ax,1234h

	mov	cl, 80	;count columns
	mov	ch, 25	;count rows


	;put b800 hex into ds by way of ax
	mov	ax, 0b800h
	mov	es, ax

	;start at the top
	mov	di, 0A0h

;put asterisk into video memory, by way of al

clear:
	mov	al, 'I'	;move asterisk to al
	mov	ah,0
	mov	[es:di], al	;move al to the content of si
	inc	di	;increment di to put in color
	mov	al, 3	;set color to black
	mov	ah, 0
	mov	[es:di], al	;move black to content of si
	inc	di	;increment to get back to a new pixel

	dec	cl	;go down column
	jnz	clear
	mov	cl, 80	;reset column to 80
	dec	ch	;go down row
	jnz	clear

	mov	cx, 0

fill:
	mov	ah, 0	;set upper bit to 0
	mov	al, ch	;current row, cl, to update row, al
	mov	bl, 80	;for the equation
	mov	bh, 0
	mul	bx	;multiply ax by 80
	mov	bl, cl
	mov	bh, 0
	add	ax, bx
	mov	bl, 2
	mov	bh, 0
	mul	bx	;multiply ax by 2
	mov	di, ax

	mov	al, '*'	;move asterisk to al
	mov	[es:di], al	;move al to the content of si
	inc	di	;increment di to put in color
	mov	al,0	;set color to black
	mov	ah,0
	mov	[es:di], al	;move black to content of si
	inc	di	;increment to get back to a new pixel

	inc	cl	;go down column
	cmp	cl, 12
	jne	fill
	mov	cl, 0	;reset column
	inc	ch	;go down row
	cmp	ch, 21
	jne	fill

	mov	cl, 0	;reset

	borders:
	mov	ah, 0	;set upper bit to 0
	mov	al, cl	;current row, cl, to update row, al
	mov	bl, 80	;for the equation
	mov	bh, 0
	mul	bx	;multiply ax by 80
	mov	bl, 2
	mov	bh, 0
	mul	bx	;multiply ax by 2
	mov	di, ax

	;left column
	mov	al,'|'	;move it in
	mov	ah,0
	mov	[es:di], al
	inc	di
	mov	al, 7	;set color to white
	mov	ah, 0
	mov	[es:di], al
	inc	di


	;right column
	add	di, 20	;other column
	mov	al, '|'	;move it inn
	mov	ah, 0
	mov	[es:di], al
	inc	di
	mov	al, 7	;set color to white
	mov	ah, 0
	mov	[es:di], al

	inc	cl	;increment row
	cmp	cl, 19
	jle	borders

	;bottom border
	mov	cl, 0	;columns

bb:
	mov	al, 20	;current row, al
	mov	bl, 80	;for the equation
	mov	ah, 0	;set upper bit to 0
	mov	bh, 0
	mul	bx	;multiply ax by 80
	mov	ch,0
	add	ax, cx	;add column to equation
	mov	bl, 2
	mov	bh, 0
	mul	bx	;multiply ax by 2
	mov	di, ax

	mov	al,'-'	;move it inn
	mov	[es:di], al
	inc	di
	mov	al, 7	;set color to white
	mov	[es:di], al

	inc	cl
	cmp	cl, 11
	jle	bb

	main:
	;mov	cl,6
	;mov	ch,18
	;call	getpix
	;call	setpix

	;mov	si, offset piecex_line
	;call	setpie

	;mov	si, offset currentpiecex
	call	show


term:
	mov	ah,0
	int	21h

	;unreachable code
	getpix:
	push	dx
	push	bx
	push	cx

	mov	al, ch	;current row, ch, to update row, al
	mov	bl, 80	;for the equation
	mov	bh, 0
	mul	bx	;multiply ax by 80
	mov	bl, cl
	mov	bh, 0
	add	ax, bx
	mov	bl, 2
	mov	bh, 0
	mul	bx	;multiply ax by 2
	mov	di, ax

	;the pixel
	inc	di
	mov	al, [es:di]

	pop	cx
	pop	bx
	pop	dx
	ret		;returns pixel color in al

setpix:
	push	ax
	push	dx
	push	bx
	push	cx

	mov	ah, 0	;set upper bit to 0
	mov	al, ch	;current row, ch, to update row, al
	mov	bl, 80	;for the equation
	mov	bh, 0
	mul	bx	;multiply ax by 80
	mov	bl, cl
	mov	bh, 0
	add	ax, bx
	mov	bl, 2
	mov	bh, 0
	mul	bx	;multiply ax by 2
	mov	di, ax

	mov	al, '*'	;move asterisk to al
	mov	[es:di], al	;move al to the content of si
	inc	di	;increment di to put in color
	mov	bl, [es:di]
	cmp	bl, 0
	je	btow	;jump to btow if the pixel is black
	mov	al,0	;set color to black
	mov	ah,0
	mov	[es:di], al	;move black to content of si

	jmp	endset

btow:
	mov	al, 7	;changes to white
	mov	ah, 0
	mov	[es:di], al	;move white to content of si

endset:

	pop	cx
	pop	bx
	pop	dx
	pop	ax
	ret

setpie:
	push	ax
	push	bx
	push	cx
	push	dx

	mov	bl, 0
	mov	si, offset piecex_line

setLoop:
	;push value to stack
	mov	dl, [si]	;moves content of si into column
	mov	dh, 0
	push	dx

	;finish out the loop
	inc	si
	inc	bl
	cmp	bl, 8
	jnz	setLoop

	mov	si, offset currentpiecex
	add	si, 7
	mov	bl, 0

popLoop:
	;pop value from stack
	pop	dx
	mov	[si], dl	;moves content of si into column

	;finish out the loop
	dec	si
	inc	bl
	cmp	bl, 8
	jnz	popLoop

	pop	dx
	pop	cx
	pop	bx
	pop	ax
	ret

show:
	push	ax
	push	bx
	push	cx
	push	dx
	push	si

	mov	si, offset piecey_box
	mov	bl, 4
	mov	bh, 0
	sub	si,bx
	mov	si, offset piecex_box

	mov	bl, 0

showLoop:
	mov	cl, [si]	;into column
	mov	ch, [si+4]	;into row

	call	setpix
	add	si, 1
	inc	bl
	cmp	bl, 4
	jnz	showLoop

	pop	si
	pop	dx
	pop	cx
	pop	bx
	pop	ax
ret

code	ends

data	segment
;pieces
piecex_line     db      5,5,5,5
piecey_line     db      0,1,2,3
piecex_l        db      5,6,7,5
piecey_l        db      0,0,0,1
piecex_r        db      5,6,7,7
piecey_r        db      0,0,0,1
piecex_s        db      5,6,6,7
piecey_s        db      1,1,0,0
piecex_z        db      5,6,6,7
piecey_z        db      0,0,1,1
piecex_t        db      5,6,7,6
piecey_t        db      0,0,0,1
piecex_box      db      5,6,5,6
piecey_box      db      0,0,1,1

;piece holders
currentpiecex  db      0,0,0,0
currentpiecey  db      0,0,0,0

data	ends
end	start