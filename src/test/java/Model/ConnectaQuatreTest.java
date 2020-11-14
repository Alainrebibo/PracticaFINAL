package Model;

import static org.junit.Assert.*;

import java.awt.print.Printable;

import org.junit.Before;
import org.junit.Test;

public class ConnectaQuatreTest {
	
	@Test
	public void testgetAmplada(){
		ConnectaQuatre c4=new ConnectaQuatre(3,4);
		int c4amplada=c4.getAmplada();
		assertEquals(3, c4amplada);
	}
	@Test
	public void testgetAltura(){
		ConnectaQuatre c4=new ConnectaQuatre(3,4);
		int c4altura=c4.getAltura();
		assertEquals(4, c4altura);
	}
	@Test
	public void testgetTauler()
	{
		ConnectaQuatre c4=new ConnectaQuatre(5, 9);
		char c4tauler[][]= c4.getTauler();
		 int amplada = c4tauler[0].length;
		 int altura =c4tauler.length;
		 assertEquals(5, amplada);
		 assertEquals(9, altura);
	}
	@Test
	public void testgetJugador(){
		ConnectaQuatre c4= new ConnectaQuatre(5, 6);
		char Jugador1= c4.getJugador()[0];
		char Jugador2= c4.getJugador()[1];
		assertEquals('Y', Jugador2);
		assertEquals('R', Jugador1);
	}
	@Test
	public void testConnectaQuatre() {
		ConnectaQuatre c4=new ConnectaQuatre(5, 9);
		 assertEquals( c4.getAltura(),9 );
		 assertEquals(c4.getAmplada(), 5);
		 for(int i = 0;i<c4.getAltura();i++) {
			 for(int j=0;j<c4.getAmplada();j++) {
				 assertEquals('.', c4.getTauler()[i][j]);
			 }
		 }
	}
	@Test
	public void testGetUltCol(){
		ConnectaQuatre c4=new ConnectaQuatre(3,4);
		int c4ultCol=c4.getUltCol();
		assertEquals(-1, c4ultCol);
	}
	@Test
	public void testGetUltRow(){
		ConnectaQuatre c4=new ConnectaQuatre(3,4);
		int c4ultRow=c4.getUltRow();
		assertEquals(-1, c4ultRow);
	}
	
	@Test
	public void testSetUltCol() {
		ConnectaQuatre c4= new ConnectaQuatre(5, 6);
		c4.setUltCol(2);
		assertEquals(2, c4.getUltCol());
	}
	@Test
	public void testSetUltRow() {
		ConnectaQuatre c4= new ConnectaQuatre(5, 6);
		c4.setUltRow(2);
		assertEquals(2, c4.getUltRow());
	}
	@Test
	public void testHoritzontal() {
		ConnectaQuatre c4=new ConnectaQuatre(5, 9);
		 for(int j=0;j<c4.getAmplada();j++) {
			  c4.getTauler()[0][j]='H';
		 }
		 c4.setUltRow(0);
		 String sHoritzontal= c4.horitzontal();
		 String proba = "HHHHH";
		 assertEquals(proba, sHoritzontal);
		 
	}
	@Test
	public void testVertical() {
		//Funcionament normal de la funci�
		ConnectaQuatre c4=new ConnectaQuatre(5, 9);
		 for(int j=0;j<c4.getAltura();j++) {
			  c4.getTauler()[j][0]='H';
		 }
		 c4.setUltCol(0);
		 String sVertical= c4.vertical();
		 String proba="HHHHHHHHH";
		 assertEquals(proba, sVertical);
		 //Valor limit per evitar el loop
		 ConnectaQuatre c4limit =new ConnectaQuatre(6, 0);
		 for(int j=0;j<c4limit.getAltura();j++) {
			  c4limit.getTauler()[j][0]='H';
		 }
		 c4limit.setUltCol(0);
		 String verticallimit= c4limit.vertical();
		 assertEquals("", verticallimit);
		//Valor limit per evitar el loop
		 ConnectaQuatre c41loop =new ConnectaQuatre(6, 1);
		 for(int j=0;j<c41loop.getAltura();j++) {
			  c41loop.getTauler()[j][0]='H';
		 }
		 c41loop.setUltCol(0);
		 String verticallimit1= c41loop.vertical();
		 assertEquals("H", verticallimit1);
		 //Valor limit gran per fer moltes passadas
		 ConnectaQuatre c4gran =new ConnectaQuatre(6, 15);
		 for(int j=0;j<c4gran.getAltura();j++) {
			  c4gran.getTauler()[j][0]='H';
		 }
		 c4gran.setUltCol(0);
		 String verticallimitgran= c4gran.vertical();
		 System.out.println(verticallimitgran);
		 assertEquals("HHHHHHHHHHHHHHH", verticallimitgran);
		 
		
		 
	}
	@Test
	public void testDiagonalPositiva() {
		ConnectaQuatre c4=new ConnectaQuatre(5, 9);
		c4.setUltCol(0);
		c4.setUltRow(8);
	    for (int alt = 0; alt < c4.getAltura(); alt++) {
	      int amp = c4.getUltCol() + c4.getUltRow() - alt;

	      if (0 <= amp && amp < c4.getAmplada()) {
	        c4.getTauler()[alt][amp]='H';
	      		}
	    }
	     
		 String sDiagonalPositiva= c4.diagonalPositiva();
		 String proba="HHHHH";
		 assertEquals(proba, sDiagonalPositiva);
		 
	}
	@Test
	public void testDiagonalNegativa() {
		ConnectaQuatre c4=new ConnectaQuatre(5, 9);
		c4.setUltCol(4);
		c4.setUltRow(8);
	    for (int alt = 0; alt < c4.getAltura(); alt++) {
	      int amp = c4.getUltCol() - c4.getUltRow() + alt;

	      if (0 <= amp && amp < c4.getAmplada()) {
	        c4.getTauler()[alt][amp]='H';
	      		}
	    }
	     
		 String sDiagonalNegativa= c4.diagonalNegativa();
		 String proba="HHHHH";
		 assertEquals(proba, sDiagonalNegativa);
		 
	}

}

