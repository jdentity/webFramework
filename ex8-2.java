import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class SaxHandlerClass2 extends DefaultHandler
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("start...");
        SaxHandlerClass2 saxhandler = new SaxHandlerClass2();
        saxhandler.read(args[0]);
    }

    public void read(String fileName) throws Exception
    {
        XMLReader readerObj = XMLReaderFactory.createXMLReader(
                "org.apache.xerces.parsers.SAXParser");
        readerObj.setContentHandler(this);
        readerObj.parse(fileName);
    }

    public void startDocument() throws SAXException
    { System.out.println("parsing start ... "); }

    public void endDocument() throws SAXException
    { System.out.println("parsing end."); }

    public void startElement(String uri, String localName,
                             String fullName, Attributes atts) throws SAXException
    {
        System.out.println("Element is " + fullName);
        strbuf.setLength(0);
    }

    StringBuffer strbuf = new StringBuffer();
    public void characters(char[] chars, int start, int len) {
        strbuf.append(chars, start, len);
    }

    public void endElement(String uri, String localName, String fullname){
        if(strbuf.length() >0) {
            System.out.println(localName + "has " + strbuf);
            strbuf.setLength(0);
        }
    }
}