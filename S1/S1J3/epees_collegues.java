class epees_collegues {
	
	
	public static void afficher(String arr[])
	{
		for(int i = 0; i < arr.length; i++)
	{
  	System.out.println("À l'emplacement " + i +" du tableau nous avons = " + arr[i] +"\n");
	}
	}
	
	public static void affichetab(String prenoms[])
	{
  	for(String str : prenoms)
  	System.out.println(str);
	}
	
      static void  TriBulle  (String[] table )    {
    int  n  =  table.length - 1 ; 
	String str1,str2;
   for (  int  i  =  n ;  i >= 1 ;  i -- )
    for (  int  j  =  2 ;  j <= i ;  j ++ ){ 
	str1=table[j - 1]	;
    str2=table[j] ;
	
     if ( str1.compareTo( str2 ) > 0 )
     {
       String  temp  =  table[j - 1] ;
       table[j - 1]  =  table[j] ;
       table[j]  =  temp ;
	}}
  }

	


    public static void main (String[] args){
        
	
	String prenoms[] = {"Alban", "Jim", "Bob", "Albatroz", "Jinto", "Bow", "Hijo", "Manu", "Seb", "Teilo", "Charles", "Xavier"};
	//afficher(prenoms);
	affichetab(prenoms);
	// tri des elements de tableau avec le tri a bulle
     TriBulle (prenoms);
	 System.out.println("---Apres le tri a bulle---");  
	affichetab(prenoms);;

    }
	
	
	
}
