package personatge;

public class Guerrer extends Personatge {

    @Override
    public String missatgePosicio() {
            return "Et pots moures d'1 en 1";
    }
    
    @Override
    public void moure(char [] direccio) {
        int [] posicio;
        boolean correcte;
        posicio = super.getPosicioPersonatge();
        
        for (int i = 0; i < direccio.length; i++) {
            switch (direccio[i]){
                case 'W': case 'S':
                    correcte = super.checkMoviment(direccio[i]);
                    if(correcte==true){
                        posicio[0]++;
                        super.setPosicioPersonatge(posicio);
                    }else{
                        System.out.println("Error. No te puedes mover");
                    }
                    break;
                case 'A': case 'D':
                    correcte = super.checkMoviment(direccio[i]);
                    if(correcte==true){
                        posicio[1]++;
                        super.setPosicioPersonatge(posicio);
                    }else{
                        System.out.println("Error. No te puedes mover");
                    }
                    break;
            }
        }
    }
    

    @Override
    public void batalla() {
        
    }
    
    
	
}
