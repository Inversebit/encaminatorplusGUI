/**
* 	Copyright (C) 2014 Inversebit
* 
* 	This program is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.
	
	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.
	
	You should have received a copy of the GNU General Public License
	along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package org.inversebit.scp_algor_encam_gui.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


public class Main extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblIntroText;
	private JLabel lblk;
	private JTextField tFk;
	private JLabel lbln;
	private JTextField tFn;
	private JLabel lblanillo;
	private JComboBox<String> cBAnillo;
	private JLabel lblOrigen;
	private JLabel lblDestino;
	private JTextField tFOrigen;
	private JTextField tFDestino;
	private JButton btnCalcular;
	private JLabel lblResultadosText;
	private JLabel lblSeparator;
	private JLabel lblDistancia;
	private JLabel lblDistanciaResult;
	private JLabel lblRE;
	private JLabel lblREResult;
	private JLabel lblPaso;
	private JTextArea tAPasoResult;
	private JButton btnReset;
	private JLabel lblErrores;
	private JLabel lblErroresText;

	private PipedOutputStream pipeStdOut;
	private PipedInputStream pipeStdIn;
	private PipedOutputStream pipeErrOut;
	private PipedInputStream pipeErrIn;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{				
		EventQueue.invokeLater(new Runnable() {

			public void run()
			{
				try
				{
					try {
						  UIManager.setLookAndFeel(
						    UIManager.getSystemLookAndFeelClassName());
						  } catch (Exception e) {
						    e.printStackTrace();
						}
					Main frame = new Main();
					
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	private void redirectSystemOutput()
	{
		pipeStdOut = new PipedOutputStream();
		pipeErrOut = new PipedOutputStream();
		
		try
		{
			pipeStdIn = new PipedInputStream(pipeStdOut);
			pipeErrIn = new PipedInputStream(pipeErrOut);
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		
		System.setOut(new PrintStream(pipeStdOut));
		System.setErr(new PrintStream(pipeErrOut));	
	}

	/**
	 * Create the frame.
	 */
	public Main()
	{
		initialize();
	}
	private void initialize() {
		setTitle("EncaminatorPlusGUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 273);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblIntroText());
		contentPane.add(getLblk());
		contentPane.add(getTFk());
		contentPane.add(getLbln());
		contentPane.add(getTFn());
		contentPane.add(getLblanillo());
		contentPane.add(getCBAnillo());
		contentPane.add(getLblOrigen());
		contentPane.add(getLblDestino());
		contentPane.add(getTFOrigen());
		contentPane.add(getTFDestino());
		contentPane.add(getBtnCalcular());
		contentPane.add(getLblResultadosText());
		contentPane.add(getLblSeparator());
		contentPane.add(getLblDistancia());
		contentPane.add(getLblDistanciaResult());
		contentPane.add(getLblRE());
		contentPane.add(getLblREResult());
		contentPane.add(getLblPaso());
		contentPane.add(getTAPasoResult());
		contentPane.add(getBtnReset());
		contentPane.add(getLblErrores());
		contentPane.add(getLblErroresText());
	}
	private JLabel getLblIntroText() {
		if (lblIntroText == null) {
			lblIntroText = new JLabel("Introduce los datos de tu red:");
			lblIntroText.setBounds(10, 11, 144, 14);
		}
		return lblIntroText;
	}
	private JLabel getLblk() {
		if (lblk == null) {
			lblk = new JLabel("Nodos por dimensi\u00F3n:");
			lblk.setBounds(20, 39, 103, 14);
		}
		return lblk;
	}
	private JTextField getTFk() {
		if (tFk == null) {
			tFk = new JTextField();
			tFk.setBounds(140, 36, 58, 20);
			tFk.setColumns(10);
		}
		return tFk;
	}
	private JLabel getLbln() {
		if (lbln == null) {
			lbln = new JLabel("N\u00FAmero de dimensiones:");
			lbln.setBounds(20, 67, 122, 14);
		}
		return lbln;
	}
	private JTextField getTFn() {
		if (tFn == null) {
			tFn = new JTextField();
			tFn.setColumns(10);
			tFn.setBounds(140, 64, 58, 20);
		}
		return tFn;
	}
	private JLabel getLblanillo() {
		if (lblanillo == null) {
			lblanillo = new JLabel("Tipo de red:");
			lblanillo.setBounds(20, 92, 58, 14);
		}
		return lblanillo;
	}
	private JComboBox<String> getCBAnillo() {
		if (cBAnillo == null) {
			cBAnillo = new JComboBox<String>();
			cBAnillo.setBounds(140, 92, 84, 20);
			cBAnillo.addItem("Malla");
			cBAnillo.addItem("Toro");
		}
		return cBAnillo;
	}
	private JLabel getLblOrigen() {
		if (lblOrigen == null) {
			lblOrigen = new JLabel("Nodo origen:");
			lblOrigen.setBounds(20, 117, 62, 14);
		}
		return lblOrigen;
	}
	private JLabel getLblDestino() {
		if (lblDestino == null) {
			lblDestino = new JLabel("Nodo destino:");
			lblDestino.setBounds(20, 142, 67, 14);
		}
		return lblDestino;
	}
	private JTextField getTFOrigen() {
		if (tFOrigen == null) {
			tFOrigen = new JTextField();
			tFOrigen.setBounds(140, 114, 58, 20);
			tFOrigen.setColumns(10);
		}
		return tFOrigen;
	}
	private JTextField getTFDestino() {
		if (tFDestino == null) {
			tFDestino = new JTextField();
			tFDestino.setColumns(10);
			tFDestino.setBounds(140, 139, 58, 20);
		}
		return tFDestino;
	}
	private JButton getBtnCalcular() {
		if (btnCalcular == null) {
			btnCalcular = new JButton("Calcular");
			btnCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getBtnCalcular().setEnabled(false);
					
					redirectSystemOutput();
					
					String[] args = extractArguments();
					
					org.inversebit.scp_algor_encam.main.Main.mainRet(args);
					
					try{
						
						if(pipeErrIn.available() > 0){
							String error = "";
							int errChar;
							
							while((errChar = pipeErrIn.read()) != 10){
								error = error + (char)errChar;				
							}
	
							getLblErroresText().setText(error);
						}
						else
						{
							int i = 0;
							while(i < 3){
								String result = "";
								int aChar;
								
								while((aChar = pipeStdIn.read()) != 10){
									result = result + (char)aChar;				
								}
								
								String[] aux = result.split(":");
								
								switch(i){
									case 0:
										
										getLblDistanciaResult().setText(aux[1]);
										break;
									case 1:
										getLblREResult().setText(aux[1]);
										break;
									case 2:
										getTAPasoResult().setText(aux[1]);
										break;
								}
								
								i++;
							}
						}
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
					
					closeStreams();
				}

				private void closeStreams()
				{
					try{
						pipeErrIn.close();
						pipeErrOut.close();
						pipeStdIn.close();
						pipeStdOut.close();	
					}
					catch(IOException e){
						e.printStackTrace();
					}
				}

				private String[] extractArguments()
				{
					String[] result = new String[5];
					result[0] = getTFk().getText();
					result[1] = getTFn().getText();
					result[2] = Integer.toString(getCBAnillo().getSelectedIndex());
					result[3] = getTFOrigen().getText();
					result[4] = getTFDestino().getText();
					return result;
				}
			});
			btnCalcular.setBounds(20, 177, 89, 23);
		}
		return btnCalcular;
	}
	private JLabel getLblResultadosText() {
		if (lblResultadosText == null) {
			lblResultadosText = new JLabel("Resultados:");
			lblResultadosText.setBounds(246, 11, 62, 14);
		}
		return lblResultadosText;
	}
	private JLabel getLblSeparator() {
		if (lblSeparator == null) {
			lblSeparator = new JLabel("");
			lblSeparator.setBounds(233, 10, 2, 190);
			lblSeparator.setOpaque(true);
			lblSeparator.setBackground(Color.BLACK);
		}
		return lblSeparator;
	}
	private JLabel getLblDistancia() {
		if (lblDistancia == null) {
			lblDistancia = new JLabel("Distancia:");
			lblDistancia.setBounds(246, 39, 47, 14);
		}
		return lblDistancia;
	}
	private JLabel getLblDistanciaResult() {
		if (lblDistanciaResult == null) {
			lblDistanciaResult = new JLabel("");
			lblDistanciaResult.setBounds(297, 39, 29, 14);
		}
		return lblDistanciaResult;
	}
	private JLabel getLblRE() {
		if (lblRE == null) {
			lblRE = new JLabel("RE:");
			lblRE.setBounds(246, 67, 46, 14);
		}
		return lblRE;
	}
	private JLabel getLblREResult() {
		if (lblREResult == null) {
			lblREResult = new JLabel("");
			lblREResult.setBounds(297, 67, 186, 14);
		}
		return lblREResult;
	}
	private JLabel getLblPaso() {
		if (lblPaso == null) {
			lblPaso = new JLabel("Nodos por los que pasa el mensaje:");
			lblPaso.setBounds(246, 92, 170, 14);
			
		}
		return lblPaso;
	}
	private JTextArea getTAPasoResult() {
		if (tAPasoResult == null) {
			tAPasoResult = new JTextArea();
			tAPasoResult.setEditable(false);
			tAPasoResult.setBounds(246, 112, 237, 88);
			tAPasoResult.setLineWrap(true);
		}
		return tAPasoResult;
	}
	private JButton getBtnReset() {
		if (btnReset == null) {
			btnReset = new JButton("Resetear");
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Main m = new Main();
					m.setVisible(true);
					dispose();
				}
			});
			btnReset.setBounds(135, 177, 89, 23);
		}
		return btnReset;
	}
	private JLabel getLblErrores() {
		if (lblErrores == null) {
			lblErrores = new JLabel("Errores:");
			lblErrores.setBounds(20, 211, 39, 14);
		}
		return lblErrores;
	}
	private JLabel getLblErroresText() {
		if (lblErroresText == null) {
			lblErroresText = new JLabel("Ninguno");
			lblErroresText.setBounds(63, 211, 420, 14);
		}
		return lblErroresText;
	}
}
