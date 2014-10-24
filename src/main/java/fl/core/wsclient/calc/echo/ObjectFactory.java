package fl.core.wsclient.calc.echo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the fl.core.wsclient.calc.echo package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Echo_QNAME = new QName("http://ws.calc.fl/", "echo");
    private final static QName _EchoResponse_QNAME = new QName("http://ws.calc.fl/", "echoResponse");
    private final static QName _HowManyMonkeysResponse_QNAME = new QName("http://ws.calc.fl/", "howManyMonkeysResponse");
    private final static QName _HowManyMonkeys_QNAME = new QName("http://ws.calc.fl/", "howManyMonkeys");

    /**
     * Create a new ObjectFactory that can be used to create new instances of
     * schema derived classes for package: fl.core.wsclient.calc.echo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HowManyMonkeys }
     * 
     */
    public HowManyMonkeys createHowManyMonkeys() {
        return new HowManyMonkeys();
    }

    /**
     * Create an instance of {@link EchoResponse }
     * 
     */
    public EchoResponse createEchoResponse() {
        return new EchoResponse();
    }

    /**
     * Create an instance of {@link Echo_Type }
     * 
     */
    public Echo_Type createEcho_Type() {
        return new Echo_Type();
    }

    /**
     * Create an instance of {@link HowManyMonkeysResponse }
     * 
     */
    public HowManyMonkeysResponse createHowManyMonkeysResponse() {
        return new HowManyMonkeysResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Echo_Type }
     * {@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.calc.fl/", name = "echo")
    public JAXBElement<Echo_Type> createEcho(Echo_Type value) {
        return new JAXBElement<Echo_Type>(_Echo_QNAME, Echo_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EchoResponse }
     * {@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.calc.fl/", name = "echoResponse")
    public JAXBElement<EchoResponse> createEchoResponse(EchoResponse value) {
        return new JAXBElement<EchoResponse>(_EchoResponse_QNAME, EchoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link HowManyMonkeysResponse }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.calc.fl/", name = "howManyMonkeysResponse")
    public JAXBElement<HowManyMonkeysResponse> createHowManyMonkeysResponse(HowManyMonkeysResponse value) {
        return new JAXBElement<HowManyMonkeysResponse>(_HowManyMonkeysResponse_QNAME, HowManyMonkeysResponse.class,
                null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HowManyMonkeys }
     * {@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.calc.fl/", name = "howManyMonkeys")
    public JAXBElement<HowManyMonkeys> createHowManyMonkeys(HowManyMonkeys value) {
        return new JAXBElement<HowManyMonkeys>(_HowManyMonkeys_QNAME, HowManyMonkeys.class, null, value);
    }

}
