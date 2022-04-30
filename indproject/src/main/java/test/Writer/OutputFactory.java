package test.Writer;

public class OutputFactory {
    public Writer getOutputWriter(String outputType){
        Writer writer = null;
        if(outputType.equals("Tickets")){
            writer = new TicketWriter();
        }
        else if (outputType.equals("Error")){
            writer = new ErrorWriter();
        }

        return writer;
    }
}
