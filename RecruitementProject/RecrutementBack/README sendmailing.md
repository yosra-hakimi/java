
Description of "API REST send mail " :

 
HTTP METHOD	     | URI | Action | Input | Ouput
| -------------- | ----| ------ | ----- |-----|
| POST | http://localhost:8080/meeting | SEND MAIL  | MAIL | mail are sended |


pour l'envoie d'un mail  :
```
{

	"receiver":"mouna.makni@talan.com",

	"subject":"test spring mailing",

	"text":"you have a meeting the next week"

}
```