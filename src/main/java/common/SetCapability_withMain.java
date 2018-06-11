package common;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class SetCapability_withMain {

    public static void main(String[] args) {
        String capability="./src/main/resources/config/desiredcapabilities/capability.xml";
        File capFile = new File(capability);
        if(capFile.exists()) {
            System.out.println("File exists :"+capability);

            SAXReader reader = new SAXReader();
            Document document = null;
            try {
                document = reader.read( capFile );
            } catch (DocumentException e) {
                e.printStackTrace();
            }

            System.out.println("Root element :" + document.getRootElement().getName());

            Element classElement = document.getRootElement();

         /*   List<Node> nodes;
            String nodePathLocal="/capability/local";
            nodes = document.selectNodes(nodePathLocal);
            System.out.println(" local nodes "+nodes.size());
            for (Node node : nodes) {
                System.out.println("\nCurrent Element :"
                        + node.getName());
                List<Node> tmp=node.selectNodes("*");
                System.out.println("size of child : "+tmp.size());

            }*/

            String nodePathLocal="/capability/sauce";
            Node localNode = document.selectSingleNode(nodePathLocal);
            List<Node> childLocalNodes = localNode.selectNodes("*");
            System.out.println("size of childLocalNodes : "+childLocalNodes.size());

            for ( Node childNode : childLocalNodes  ) {
                String nodeName=childNode.getName();
                String nodeValue=childNode.getText();
                System.out.println(nodeName +" | "+nodeValue);

            }


        } else {
            System.out.println("File Does NOT exists :"+capability);
        }


    }
}
