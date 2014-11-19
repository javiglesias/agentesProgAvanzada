package Agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

import java.util.Scanner;


@SuppressWarnings("serial")
public class Agente extends Agent 
{
	@SuppressWarnings("unused")
	private static final long serialVerisonUID = 1L;
	protected CyclicBehaviour cyclicBehaviour;
	Scanner sc = new Scanner(System.in);
	String message;
	
		public void setup()
		{
			cyclicBehaviour = new CyclicBehaviour(this)
			{

				@Override
				public void action() 
				{
					/*asi es como se envian los mesajes sin la clase utils:
					DFAgentDescription dfd = new DFAgentDescription();
					dfd.setName(getAID());s
					ACLMessage mensaje = new ACLMessage(ACLMessage.REQUEST);
					AID aid = dfd.getName();
					mensaje.addReceiver(aid);
					//la ontologia definida es estandar, para todos igual
					mensaje.setOntology("onltologia");
					//el lenguaje con el que se va a enviar el mensaje
					mensaje.setLanguage(new SLCodec().getName());
					//el mensaje se trasnmitira por XML
					mensaje.setEnvelope(new Envelope());
					//cambiamos la cofigicacion de la carta
					mensaje.getEnvelope().setPayloadEncoding("ISO8859_1");
					mensaje.getEnvelope().setAclRepresentation(FIPANames.ACLCodec.XML);
					try {
						System.out.println("Escriba el mensaje: ");
						message = sc.nextLine();
						mensaje.setContentObject((Serializable)message);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					send(mensaje);*/
					//nosotros usaremos la clase utils para enviar mesajes.
					System.out.println("Escriba el mensaje: ");
					message = sc.nextLine();
					Utils.enviarMensaje(this.myAgent, "buscar", message);
				}
				
			};
			addBehaviour(cyclicBehaviour);
		}
}