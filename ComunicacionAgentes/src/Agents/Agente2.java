package Agents;
import jade.content.lang.sl.SLCodec;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;


public class Agente2 extends Agent 
{
	private static final long serialVerisonUID = 1L;
	protected CyclicBehaviour cyclicBehaviour;
		public void setup()
		{
			DFAgentDescription dfd = new DFAgentDescription();
			dfd.setName(getAID());
			ServiceDescription sd = new ServiceDescription();
			//dfd.setName("avellana");
			sd.setType("buscar");
			sd.setName("avellana");
			sd.addOntologies("ontologia");
			sd.addLanguages(new SLCodec().getName());
			dfd.addServices(sd);
			
			try
			{
				DFService.register(this, dfd);
			}
			catch(Exception e)
			{
				System.out.println("Error en el registro del DFService");
			}
			
			cyclicBehaviour = new CyclicBehaviour(this)
			{

				@Override
				public void action() 
				{
					

					ACLMessage mensaje = 
							blockingReceive(
									MessageTemplate.and(
											MessageTemplate.MatchPerformative(ACLMessage.REQUEST),
											MessageTemplate.MatchOntology("ontologia")));
					
					try {
						System.out.println("mensaje: "
								+mensaje.getContentObject());
					} catch (UnreadableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				
			};
			addBehaviour(cyclicBehaviour);
		}
}
