package personatge;
public class Main {
        
	public static void main(String[] args) {
            Personatge guerrer = new Guerrer();
            Personatge sacerdot = new Sacerdot();
            Personatge mag = new Mag();
            
            Personatge [] tipusPersonatges = {guerrer, sacerdot, mag};
                int personatge, exit, personatgeArray;
                
                personatge = guerrer.generarPersonatge();
                
                switch(personatge){
                    case 1://Guerrer
                        guerrer.setActiu(true);
                        sacerdot.setActiu(false);
                        mag.setActiu(false);
                        exit = guerrer.iniciPrograma();
                        if(exit==-2){
                            System.out.print("Ets un guerrer");
                            personatgeArray = cambiarPersonatge(tipusPersonatges);
                            tipusPersonatges[personatgeArray].programa();
                        }
                        break;
                    case 2://Sacerdot
                        sacerdot.setActiu(true);
                        guerrer.setActiu(false);
                        mag.setActiu(false);
                        exit = sacerdot.iniciPrograma();
                        if(exit==-2){
                            System.out.print("Ets un sacerdot");
                            personatgeArray = cambiarPersonatge(tipusPersonatges);
                            tipusPersonatges[personatgeArray].programa();
                        }
                        break;
                    case 3://Mag
                        mag.setActiu(true);
                        guerrer.setActiu(false);
                        sacerdot.setActiu(false);
                        exit = mag.iniciPrograma();
                        if(exit==-2){
                            System.out.print("Ets un mag");
                            personatgeArray = cambiarPersonatge(tipusPersonatges);
                            tipusPersonatges[personatgeArray].programa();
                        }
                        break;
                }
	}
        
        public static int cambiarPersonatge(Personatge [] tipusPersonatges){
            int resposta, personatge;
            String personatgeS;
            boolean error;
            do{
                System.out.println("A quin personatge vols canviar?\n1. Guerrer\n2. Sacerdot\n3. Mag");
                resposta = Teclat.llegirInt();
                switch(resposta){
                    case 1:
                        tipusPersonatges[0].setActiu(true);
                        tipusPersonatges[1].setActiu(false);
                        tipusPersonatges[2].setActiu(false);
                        error=false;
                        break;
                    case 2:
                        tipusPersonatges[1].setActiu(true);
                        tipusPersonatges[0].setActiu(false);
                        tipusPersonatges[2].setActiu(false);
                        error=false;
                        break;
                    case 3:
                        tipusPersonatges[2].setActiu(true);
                        tipusPersonatges[1].setActiu(false);
                        tipusPersonatges[0].setActiu(false);
                        error=false;
                        break;
                    default:
                        System.out.println("Respuesta incorrecta.");
                        error=true;
                }
            }while(error==true);
            personatge = quinPersonatge(tipusPersonatges);
            personatgeS = personatgeNom(personatge);
            
		System.out.println("El personatge que tens ara és el: " + personatgeS);//Mostrar els dos personatges que podem canviar
        return personatge;
        } 
        
        
        public static int quinPersonatge(Personatge [] tipusPersonatges){
            int personatge=-1;
            for (int i = 0; i < tipusPersonatges.length; i++) {
                if(tipusPersonatges[i].isActiu()==true){
                    personatge=i;
                }
            }
            return personatge;
        }
        
        public static String personatgeNom(int personatge){
            String personatgeS;
            switch(personatge){
                case 0:
                    personatgeS="Guerrer";
                    break;
                case 1:
                    personatgeS="Sacerdot";
                    break;
                case 2:
                    personatgeS="Mag";
                    break;
                default:
                    personatgeS="Hi ha hagut un error";
            }
            return personatgeS;
        }
}
