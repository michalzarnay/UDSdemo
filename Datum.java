            
            /**
             * Write a description of class Datum here.
             * 
             * @author (your name) 
             * @version (a version number or a date)
             */
            public class Datum {
                private int den;
                private int mesiac;
                private int rok;
                /**
                 * Constructor for objects of class Datum
                 */
                public Datum(int den, int mesiac, int rok) {
                    this.den = den;
                    this.mesiac = mesiac;
                    this.rok = rok;
                }
                
                public void nastavDatum(int den, int mesiac, int rok) {
                    this.den = den;
                    this.mesiac = mesiac;
                    this.rok = rok;
                }
                
                public int getDen() {
                    return this.den;
                }
                
                public int getMesiac() {
                    return this.mesiac;
                }
                
                public int getRok() {
                    return this.rok;
                }
                
                public void setDen(int den) {
                    this.den = den;
                }
                
                public void setMesiac(int mesiac) {
                    this.mesiac = mesiac;
                }
                
                public void setRok(int rok) {
                    this.rok = rok;
                }
                
                public boolean jeRokPriestupny() {
                    if (this.rok % 4 == 0)
                        if (this.rok % 100 == 0 && this.rok % 400 != 0)
                            return false;
                        else return true;
                    else return false;
                }
                
                public int pocetDniMesiaca(int mesiac) {
                    switch (mesiac) {
                        case 4:
                        case 6:
                        case 9:
                        case 11:
                            return 30;                 
                        case 2:
                            if (jeRokPriestupny())
                                return 29; 
                            else
                                return 28;
                        default:
                            return 31;
                    }
                }
                    
                public int poradovyDenRoku() {
                    int i = 1;
                    int vysledok = 0;
                    
                    while (i < this.mesiac) {
                        vysledok += pocetDniMesiaca(i);
                        i++;
                    }
                    
                    return vysledok + this.den;
                }
                
                public int zvysnyPocetDniRoku() {
                    if (jeRokPriestupny())
                        return 366 - poradovyDenRoku();
                    else
                        return 365 - poradovyDenRoku();
                }
                
                public void posunNovyDatum(int delta) {
                    this.den += delta;
                    
                    while (this.den > pocetDniMesiaca(this.mesiac)) {
                        this.den -= pocetDniMesiaca(this.mesiac);
                        this.mesiac++;
                        if (this.mesiac > 12) {
                            this.mesiac = 1;
                            this.rok++;
                        }        
                    }
                    
                    while (this.den < 1) {
                        this.mesiac--;
                        if (this.mesiac < 1) {
                            this.mesiac = 12;
                            this.rok--;
                        }
                        this.den += pocetDniMesiaca(this.mesiac);                            
                    }
                }
                
                public void vypisSa() {
                    System.out.println(this.toString());
                }
                
                public String toString() {
                    return this.den + ". " + this.mesiac + ". " + this.rok +
                        " (" + poradovyDenRoku() + ". den roku)";
                }
    }