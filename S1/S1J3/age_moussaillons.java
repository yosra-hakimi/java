class age_moussaillons {
	
	
	public static void afficher(int arr[])
	{
		for(int i = 0; i < arr.length; i++)
	{
  	System.out.println("À l'emplacement " + i +" du tableau nous avons = " + arr[i] +"\n");
	}
	}
	
	public static void affichetab(int tabage[])
	{
  	for(int age : tabage)
  	System.out.println(	age);
	}
	
 /*static void  TriSelect  (int table[] ) 
 {
   int  n  =  table.length - 1 ;
  for (  int  i  =  1 ;  i  <=  n - 1 ;  i ++ )
  {  // recommence une sous-suite 
    int  m  =  i ;  // élément frontière ai = table[ i ]
    for (  int  j  =  i + 1 ;  j  <=  n ;  j ++ )  {  // (ai+1, a2, ... , an) 
     if ( table[ j ]  <  table[ m ] )  // aj = nouveau minimum partiel
      m  =  j  ;  // indice mémorisé
    int  temp  =  table[ m ] ;
    table[ m ]  =  table[ i ] ;
    table[ i ] =  temp ;              
  }
 }} */
 
 
     static void triselection(int[] tab){
		int r= tab.length -1  ;
        for(int i=1;i<=r;i++){
            int min=i;
            for(int j=i+1;j<=r;j++)
                if(tab[j]<tab[min])min=j;
            int tmp=tab[i];
            tab[i]=tab[min];
            tab[min]=tmp;
        }
    }


	


    public static void main (String[] args){
        
	
	int tabage[] = {45, 54, 23, 32, 64, 46, 28, 82};
	//afficher(tabage);
	affichetab(tabage);
	// tri des elements de tableau avec le tri par selection
    // TriSelect (tabage);
	 triselection(tabage);
	 System.out.println("---Apres le tri par selection---");  
	 affichetab(tabage);

    }
	
	
	
}