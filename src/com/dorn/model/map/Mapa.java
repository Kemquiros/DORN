/*
 * Copyright (C) 2017 t30r3m4
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.dorn.model.map;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author t30r3m4
 */
public class Mapa {
    
        //Pueblo de argos
        Casilla[] a = new Casilla[5];
        //Camino de piedra
        Casilla[] p= new Casilla[15];

        //Mina abandonada
        Casilla[] m = new Casilla[80];
        
        //Bosque
        Casilla[] b = new Casilla[110];
        
        //Herbolario
        Casilla s ;
        
        //Trono de Zorkal
        Casilla[] t = new Casilla[11];
        
        //Cámara Ritual
        Casilla[] i = new Casilla[19];          
        
        //Cripta (Esqueletos)
        Casilla[] e = new Casilla[7];
        
        //Criaturas Mayores (Templo Oscuro)
        Casilla[] r = new Casilla[7];      
        
        //Zombi (Cementerio)
        Casilla[] z = new Casilla[7];  
        
        //Hexagonos izquierda
        Casilla[] Hi = new Casilla[101];  
        
        //Hexagonos derecha
        Casilla[] Hd = new Casilla[87];  
        
        //Caminos izquierda
        Casilla[] Ji = new Casilla[50];  
        
        //Caminos derecha
        Casilla[] Jd = new Casilla[19];  
        
        Casilla[] invocacionInicial = new Casilla[6];
    public Mapa(){
        construirMapa();
    }
    public void construirMapa(){
        
        //--------------------
        //------CONSTRUIR MAPA
        //--------------------        
        construirArgos();
        construirCaminoPiedra();
        construirMina();
        construirBosque();
        construirHerbolario();
        construirSectorIzquierda();
        construirSectorDerecha();
        construirTrono();
        

        //--------------------
        //------CONECTAR MAPA
        //--------------------
        conectarArgos();
        conectarCaminoPiedra();
        conectarMina();
        conectarBosque();
        conectarHerbolario();
        //conectarSectorIzquierda();
        //conectarSectorDerecha();
        conectarTrono();
        
        //--------------------
        //------CASILLAS ESPECIALES
        //--------------------      
        invocacionInicial[0] = b[109];
        invocacionInicial[1] = m[75];
        invocacionInicial[2] = Hi[47];
        invocacionInicial[3] = Hi[69];
        invocacionInicial[4] = Hi[96];
        invocacionInicial[5] = Hd[42];
        
        
        
    }
    public void escalar(Double factorEscaladoX,Double factorEscaladoY, boolean disminuir){
        

        escalarSector(a,factorEscaladoX,factorEscaladoY, disminuir);

        escalarSector(p,factorEscaladoX,factorEscaladoY, disminuir);

        escalarSector(m,factorEscaladoX,factorEscaladoY, disminuir); 
        
        escalarSector(b,factorEscaladoX,factorEscaladoY, disminuir);
        
        escalarSector(s,factorEscaladoX,factorEscaladoY, disminuir);
        
        escalarSector(Hi,factorEscaladoX,factorEscaladoY, disminuir);
        
        escalarSector(Hd,factorEscaladoX,factorEscaladoY, disminuir);
        
        escalarSector(t,factorEscaladoX,factorEscaladoY, disminuir); 
    }
    
    public Casilla[] getArgos(){
        return this.a;
    }
    public Casilla[] getCaminoPiedra(){
        return this.p;
    }
    public Casilla[] getMina(){
        return this.m;
    }  
    public Casilla[] getTrono(){
        return this.t;
    } 

    private void escalarSector(Casilla[] sector, Double factorEscaladoX, Double factorEscaladoY, boolean disminuir ) {
        //System.out.println("Sector: "+sector[0].getTipo());
        for(int i=0;i<sector.length;i++){
            /*System.out.println(sector[i].getTipo()+" -> "+i);
            System.out.println("Antes de escalar x:"+sector[i].getX()+"  y:"+sector[i].getY());*/
            if(disminuir){
                sector[i].setX((int) (sector[i].getX()/factorEscaladoX));
                sector[i].setY((int) (sector[i].getY()/factorEscaladoY));
            }else{
                sector[i].setX((int) (sector[i].getX()*factorEscaladoX));
                sector[i].setY((int) (sector[i].getY()*factorEscaladoY));
            }

            //System.out.println("Después de escalar x:"+sector[i].getX()+"  y:"+sector[i].getY());
        }        
    }
    private void escalarSector(Casilla casilla, Double factorEscaladoX, Double factorEscaladoY, boolean disminuir) {
            if(disminuir){
                casilla.setX((int) (casilla.getX()/factorEscaladoX));
                casilla.setY((int) (casilla.getY()/factorEscaladoY));
            }else{
                casilla.setX((int) (casilla.getX()*factorEscaladoX));
                casilla.setY((int) (casilla.getY()*factorEscaladoY));
            }
               
    }    

    private void descMinDer(int indiceCasilla) {
        m[indiceCasilla].desconectarDerecha(m[indiceCasilla+1]);
    }

    private void descMinAba(int indiceCasilla) {
        m[indiceCasilla].desconectarAbajo(m[indiceCasilla+14]);
    }

    private void construirArgos() {
        //Pueblo de argos        
        a[0] = new Casilla(1680,2140,1);
        a[1] = new Casilla(1515,2075,1);
        a[2] = new Casilla(1515,2225,1);
        a[3] = new Casilla(1800,2225,1);
        a[4] = new Casilla(1800,2075,1);        
    }

    private void construirCaminoPiedra() {
        //Camino de piedra
        p[0] = new Casilla(1147, 1715, 2);
        p[1] = new Casilla(1280, 1836, 2);
        p[2] = new Casilla(1473, 1864, 2);
        p[3] = new Casilla(1685, 1867, 2);
        p[4] = new Casilla(1912, 1730, 2);
        p[5] = new Casilla(2044, 1603, 2);
        p[6] = new Casilla(2243, 1579, 2);
        p[7] = new Casilla(2493, 1585, 2);
        p[8] = new Casilla(2727, 1585, 2);
        p[9] = new Casilla(2973, 1570, 2);
        p[10] = new Casilla(3187, 1567, 2);
        p[11] = new Casilla(3209, 1242, 2);
        p[12] = new Casilla(3200, 931, 2);
        p[13] = new Casilla(3228, 659, 2);
        p[14] = new Casilla(3223, 478, 2);        
    }

    private void construirMina() {
        //Mina abandonada
        int contC=0;
        for(int i=0;i<2;i++){//Dos primeras filas
            for(int j=0;j<12;j++){
                m[contC] = new Casilla((2130+(j*102)), (1760+(i*100)), 3); 
                contC++;
            }            
        }
        for(int i=0;i<4;i++){//Fila 3 a 6
            for(int j=0;j<14;j++){
                m[contC] = new Casilla((1930+(j*102)), (1960+(i*100)), 3); 
                contC++;
            }            
        }         
    }

    private void construirBosque() {
        //Bosque
        int contB=0;
        int contFila=0;
        int dX =89,dY=75;
        int interrupcion;
        
        
        for(int i=0;i<3;i++){//B0
            b[i]= new Casilla(518+(i*dX), 1411+(contFila*dY), 4);
            contB++;
        }
        contFila++;
        for(int i=0;i<7;i++){//B3
            b[contB]= new Casilla(202+(i*dX), 1411+(contFila*dY), 4);
            contB++;
        }
        interrupcion=0;
        contFila++;
        for(int i=0;i<6;i++){//B10
            if(i==3 || i== 5){
                interrupcion++;
            }
            b[contB]= new Casilla(155+(i*dX)+(interrupcion*dX), 1411+(contFila*dY), 4);
            contB++;
        } 
        interrupcion=0;
        contFila++;
        for(int i=0;i<6;i++){//B16
            if(i==1){
                interrupcion++;
            }
            b[contB]= new Casilla(202+(i*dX)+(interrupcion*dX), 1411+(contFila*dY), 4);
            contB++;
        }  
        interrupcion=0;
        contFila++;
        for(int i=0;i<10;i++){//B22
            b[contB]= new Casilla(155+(i*dX)+(interrupcion*dX), 1411+(contFila*dY), 4);
            contB++;
        }    
        interrupcion=0;
        contFila++;
        for(int i=0;i<9;i++){//B32
            if(i==6){
                interrupcion++;
            }
            b[contB]= new Casilla(202+(i*dX)+(interrupcion*dX), 1411+(contFila*dY), 4);
            contB++;
        }    
        interrupcion=0;
        contFila++;
        for(int i=0;i<10;i++){//B41
            if(i==6){
                interrupcion++;
            }
            b[contB]= new Casilla(155+(i*dX)+(interrupcion*dX), 1411+(contFila*dY), 4);
            contB++;
        } 
        interrupcion=0;
        contFila++;
        for(int i=0;i<11;i++){//B51
            if(i==7){
                interrupcion++;
            }
            b[contB]= new Casilla(110+(i*dX)+(interrupcion*dX), 1411+(contFila*dY), 4);
            contB++;
        }          
        interrupcion=0;
        contFila++;
        for(int i=0;i<10;i++){//B62
            if(i==3 || i==4){
                interrupcion++;
            }
            b[contB]= new Casilla(334+(i*dX)+(interrupcion*dX), 1411+(contFila*dY), 4);
            contB++;
        }      
        interrupcion=0;
        contFila++;
        for(int i=0;i<13;i++){//B72
            if(i==12){
                interrupcion+=2;
            }
            b[contB]= new Casilla(110+(i*dX)+(interrupcion*dX), 1411+(contFila*dY), 4);
            contB++;
        }     
        interrupcion=0;
        contFila++;
        for(int i=0;i<11;i++){//B85
            if(i==2){
                interrupcion++;
            }else if(i==7){
                interrupcion+=2;
            }
            b[contB]= new Casilla(155+(i*dX)+(interrupcion*dX), 1411+(contFila*dY), 4);
            contB++;
        }           
        interrupcion=0;
        contFila++;
        for(int i=0;i<13;i++){//B96
            if(i==3){
                interrupcion++;
            }else if(i==7){
                interrupcion++;
            }
            b[contB]= new Casilla(110+(i*dX)+(interrupcion*dX), 1411+(contFila*dY), 4);            
            contB++;
        }
        //Olvidé esta casilla
        b[109]= new Casilla(1178, 2095, 4);
        //Double distancia = Math.sqrt(Math.pow(b[0].getX()-b[7].getX(), 2)+Math.pow(b[0].getY()-b[7].getY(), 2));
        //System.out.println("Distancia -> "+distancia);
        /*for(int i=0;i<contB;i++){
            System.out.println("B"+i+"  x:"+b[i].getX()+"   y:"+b[i].getY());
        }*/
        
    }
    private void construirHerbolario() {
        //Herbolario
        s = new Casilla(744, 1317, 5);        
    }  
    private void construirSectorIzquierda() {
        for(int i=0;i<Hi.length;i++){
            Hi[i]= new Casilla(0, 0, 0);
        }
        Hi[47] = new Casilla(523,1232, 0);
        Hi[69] = new Casilla(1282,1569, 0);
        Hi[96] = new Casilla(2155,1436, 0);
    }
    private void construirSectorDerecha() {
        for(int i=0;i<Hd.length;i++){
            Hd[i]= new Casilla(0, 0, 0);
        }        
        Hd[42] = new Casilla(2363, 723, 0);
    }



    private void construirTrono() {
        //Trono de Zorkal
        t[0] = new Casilla(1517, 206, 3);
        t[1] = new Casilla(1592, 206+(48*1), 3);
        t[2] = new Casilla(1676, 206+(48*2), 3);
        t[3] = new Casilla(1753, 206+(48*1), 3);
        t[4] = new Casilla(1828, 206, 3);
        t[5] = new Casilla(1592, 206+(48*3), 3);
        t[6] = new Casilla(1676, 381, 3);
        t[7] = new Casilla(1753, 206+(48*3), 3);
        t[8] = new Casilla(1592, 206+(48*5), 3);
        t[9] = new Casilla(1676, 206+(48*6), 3);
        t[10] = new Casilla(1753, 206+(48*5), 3);        
    }

    private void conectarArgos() {
        a[0].setArriba(p[3]);
        a[1].setArriba(p[3]);
        a[2].setArriba(p[3]);
        a[3].setArriba(p[3]);
        a[4].setArriba(p[3]);        
    }

    private void conectarCaminoPiedra() {
        p[0].setC3(b[40]);//Falta pantano
        p[0].setDerecha(p[1]);
        p[1].setDerecha(p[2]);
        p[2].setDerecha(p[3]);
        p[3].setDerecha(p[4]);
        p[4].setDerecha(p[5]);
        p[5].setDerecha(p[6]);
        p[6].setDerecha(p[7]);
        p[7].setDerecha(p[8]);
        p[8].setDerecha(p[9]);
        p[9].setDerecha(p[10]);
        p[10].setArriba(p[11]);
        p[11].setArriba(p[12]);
        p[12].setArriba(p[13]);
        p[13].setArriba(p[14]);
        //p[14].setIzquierda(null);//Falta cerca al cementerio        
    }

    private void conectarMina() {
        //----Fila #1 Minas Abandonadas
        m[0].setDerecha(m[1]);
        m[0].setAbajo(m[12]);
        m[1].setArriba(p[6]);
        m[2].setDerecha(m[3]);
        m[3].setDerecha(m[4]);
        m[3].setAbajo(m[15]);
        m[4].setDerecha(m[5]);
        m[4].setAbajo(m[16]);
        m[5].setDerecha(m[6]);
        m[5].setAbajo(m[17]);          
        m[6].setDerecha(m[7]);
        m[6].setAbajo(m[18]);          
        m[7].setDerecha(m[8]);
        m[7].setAbajo(m[19]);         
        m[8].setDerecha(m[9]);
        m[8].setAbajo(m[20]);         
        m[9].setDerecha(m[10]);
        m[10].setAbajo(m[22]);
        m[11].setArriba(p[10]);
        m[11].setAbajo(m[23]);
        //----Fila #2 Minas Abandonadas
        m[12].setDerecha(m[13]);
        m[12].setAbajo(m[26]);
        m[13].setDerecha(m[14]);
        m[13].setAbajo(m[27]); 
        m[14].setDerecha(m[15]);
        m[15].setDerecha(m[16]);
        m[16].setDerecha(m[17]);
        m[16].setAbajo(m[30]); 
        m[17].setDerecha(m[18]);
        m[17].setAbajo(m[31]);
        m[18].setDerecha(m[19]);
        m[18].setAbajo(m[32]); 
        m[19].setDerecha(m[20]);
        m[19].setAbajo(m[33]);  
        m[21].setDerecha(m[22]);
        m[21].setAbajo(m[35]);         
        m[22].setDerecha(m[23]);
        //----Fila #3,4,5,6 Minas Abandonadas
        int casillaMina = 24;
        for(int i=0;i<4;i++){//Fila 3 a 6
            for(int j=0;j<14;j++){
                if(i!=3){//Si no es la última fila conecte abajo
                    m[casillaMina].setAbajo(m[casillaMina+14]);  
                    //System.out.println("Conecta m"+casillaMina+" abajo m"+(casillaMina+14));
                }
                if(j!=13){//Si no es la última columna conecte derecha
                    m[casillaMina].setDerecha(m[casillaMina+1]);      
                    //System.out.println("Conecta m"+casillaMina+" derecha m"+(casillaMina+1));
                }
                casillaMina++;                
            }            
        }
        //---Desconectar casillas Minas Abandonadas
        descMinDer(26);
        descMinDer(29);
        descMinDer(33);
        descMinDer(38);
        descMinDer(39);
        descMinDer(42);
        descMinDer(44);
        descMinDer(46);
        descMinDer(49);
        descMinDer(52);
        descMinDer(56);
        descMinDer(58);
        descMinDer(62);
        descMinDer(63);
        descMinDer(71);
        
        descMinAba(26);
        descMinAba(27);
        descMinAba(32);        
        descMinAba(35);
        descMinAba(36);
        descMinAba(40);
        descMinAba(41);
        descMinAba(42);
        descMinAba(44);
        descMinAba(45);
        descMinAba(47);
        descMinAba(48);
        descMinAba(51);
        descMinAba(52);
        descMinAba(53);
        descMinAba(54);        
    }

    private void conectarBosque() {
        //----------------------------------
        //------CONECTAR DERECHA 
        //----------------------------------
        ArrayList limiteFila = new ArrayList();
        limiteFila.add(3);
        limiteFila.add(7);
        limiteFila.add(6);
        limiteFila.add(6);
        limiteFila.add(10);
        limiteFila.add(9);
        limiteFila.add(10);
        limiteFila.add(11);
        limiteFila.add(10);
        limiteFila.add(13);
        limiteFila.add(11);
        limiteFila.add(13);
        int contB=0;
        for(Object num:limiteFila){
            for(int i=0;i<((int)num);i++){
                if(i!=(((int)num)-1)){//Si no es un borde
                    if((b[contB+1].getX()-b[contB].getX())<90){//Verifica la existencia de una interrupción
                        b[contB].setDerecha(b[contB+1]);
                    }                    
                }
                contB++;
            }
        }
        //----------------------------------
        //------CONECTAR C2 y C3
        //----------------------------------  
        //Distancia entre centros de los hexagonos
        Double distanciaFija = calcularDistancia(b[0],b[7]);
        distanciaFija+=(distanciaFija*0.1);//Agregar margen de error 10%
        
        for(int i=0;i<96;i++){//B96 es el inicio de la última fila
            //Primero encuentra C2 de la casilla A
            /*
            Para encontrar C2 se busca desde el i+5 hasta i+15
            la primera casilla B que sea tal que
            A.x < B.x y A.y < B.y
            Por último que la distancia entre sus centros no sea mayor
            */
            int posible=5;
            boolean encontrar=false;
            while(posible<16 && !encontrar){
                if((b[i].getX() < b[i+posible].getX()) && (b[i].getY() < b[i+posible].getY())){
                    //System.out.println("b"+i+"  b"+(i+posible)+"  cumple primera condicion");
                    //encontrar=true;
                    //break;
                    if(distanciaFija >= calcularDistancia(b[i],b[i+posible])){
                        encontrar=true;
                        break;
                    }
                }
                posible++;
            }
            if(encontrar){                
                b[i].setC2(b[i+posible]);
                //Intenta conectar en C3
                Casilla temp = b[i+posible].getIzquierda();
                if(temp!=null){
                    if(distanciaFija >= calcularDistancia(b[i],temp)){                    
                    b[i].setC3(temp);
                    }
                }
            }
        }
        
        for(int i=0;i<108;i++){
            /*      
            Ahora se verifica C3
            Aquí se encuentran las casillas cuyos C2 eran obstáculos
            */
            if(b[i].getC1()==null){
                Casilla tempC4 = b[i].getC4();
                if(tempC4!=null){//C4 existe
                    Casilla tempC1 = tempC4.getDerecha();
                    if(tempC1 != null){//C1 existe                        
                            b[i].setC1(tempC1);                                                    
                    }
                }
            }

        }
        //Conecta los casos excepcionales B84 y B95 - B15 y B21
        b[21].setC1(b[15]);
        b[95].setC1(b[84]);
        //Olvdé esta casilla
        b[109].setC1(b[70]);
        b[109].setC2(b[94]);
        b[109].setC3(b[93]);
        b[109].setIzquierda(b[83]);
        b[109].setC4(b[69]);
        
    }

    private void conectarHerbolario() {
        s.setC3(b[2]);
    }

    private void conectarSectorDerecha() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void conectarSectorIzquierda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    private void conectarTrono() {
        //Trono de Zorkal
        t[0].setC2(t[1]);
        t[1].setC2(t[2]);
        t[1].setAbajo(t[5]);
        t[2].setC1(t[3]);
        t[2].setC3(t[5]);
        t[2].setAbajo(t[6]);
        t[2].setC2(t[7]);
        t[3].setC1(t[4]);
        t[3].setAbajo(t[7]);
        t[5].setAbajo(t[8]);
        t[5].setC2(t[6]);
        t[6].setC1(t[7]);
        t[6].setC3(t[8]);
        t[6].setAbajo(t[9]);
        t[6].setC2(t[10]);
        t[7].setAbajo(t[10]);
        t[8].setC2(t[9]);
        t[9].setC1(t[10]);        
    }

    private Double calcularDistancia(Casilla casilla1, Casilla casilla2) {
        return Math.sqrt(Math.pow(casilla1.getX()-casilla2.getX(), 2)+Math.pow(casilla1.getY()-casilla2.getY(), 2));
    }
    public Casilla[] getInvocacionInicial(){
        return invocacionInicial;
    }







}
