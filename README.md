# KuReK

Simple tool to convert numbers into words to make it easier to remember. It's useful for example for historical dates.

example:\
`1410 - TuRLaĆ`\
`07 - CiaŁa`\
`15 - LaS`

_TuRLaĆ (1410r) CiaŁa (7-lipiec) do LaSu (15). - bitwa pod Grunwaldem ;)_\
`1410.07.15`

## number to letter mapping

- 1=L,T
- 2=N,Ń,Z,Ż,Ź,V
- 3=M,W
- 4=K,R,X
- 5=S,Ś
- 6=G,J
- 7=F,Ł
- 8=B
- 9=P
- 0=D,Q,C

## rules

Cz, Dz i Sz na początku liczą się jak Z!\
Słowo może się zaczynać z literki D np. DeLFiN=0172 czyli 172

Full docs and examples in doc [docs/KuReK.doc](docs/KuReK.doc)

# results

Result are in folder "[results](results)" and in Google Docs:
[PL](https://docs.google.com/spreadsheets/d/1pWFXwH81k_eqZrzDV7Nwe6LsNO2jkEKUL8y2ubH7nuI/edit?usp=sharing)
[EN](https://docs.google.com/spreadsheets/d/1eFLel0MpZb43vSTwjhtnLvegdvVvtheQYjhlNu7H7N8/edit?usp=sharing)

# LibreOffice dictionary (input)

Dictionary is a zip file, you can change the extension of the file to .zip and unpack.

### convert polish LibreOffice dictionary

`iconv -f ISO-8859-2 -t UTF-8 pl_PL.dic > pl_PL_libre_office_dic.txt`
