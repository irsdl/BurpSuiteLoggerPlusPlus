package loggerplusplus.userinterface;

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;

/**
 * Created by corey on 27/08/17.
 */
public class HelpPanel extends JPanel {

    JTextPane overviewPane;
    JTextPane fieldPane;
    JTabbedPane contentPane;

    public HelpPanel(){
        contentPane = new JTabbedPane();
        this.setLayout(new BorderLayout());
        ScrollablePanel scrollablePanel;

        overviewPane = new JTextPane();
        overviewPane.setContentType("text/html");
        overviewPane.setEditable(false);
        overviewPane.setEditorKit(new HTMLEditorKit());
        overviewPane.setText("<html><h1>Logger++</h1><span>Logger++ was developed as an alternative to the log history included within Burp Suite. Advantages over the original implementation are a more comprehensive number of fields, the ability to show only specific entries to better monitor activity via the use of adaptable filters from various fields and row coloring to highlight interesting entries which match a specific filter.</span><br /><br /><h2>Creating Filters</h2><span>Filters were developed with the intention of being highly customisable and therefore may be as simple or complex as you require. Once a filter has been entered, the color of the input field will change to reflect the validity of the filter. If a field is correctly entered, it will be converted to uppercase.</span><br /><br /><span>The basic format of a filter is:</span> <i>FIELD OP VALUE</i><br /><b>FIELD:</b> Most fields are self-descriptively named however to find the name of a filter, right clicking the grepTable header in the field will display the grepTable name and it's filter name in brackets (). <br /><i>E.g. Extension (UrlExtension)</i><br /><b>OP:</b> Comparison operation. <i>Valid operations are <, >, <=, >=, !=, ==.</i><br /><b>VALUE:</b> String, numerical or regex value.<br /><br />Multiple filters can be combined using && and || operators and can be nested on multiple levels.<br />E.g. FILTER && FILTER<br />FILTER || FILTER<br />FILTER && (FILTER || FILTER)<br />FILTER || (FILTER && (FILTER || FILTER))<br /><br /><h2>Using Regular Expressions</h2><span>Instead of static values, regular expressions can be used within filters. To do so simply wrap the regular expression with forward slashes such as /regex/<br />To restrict results to values which are an exact match, i.e non partial matches, anchors should be placed on either side of the word.</span><br/><span>E.g. QUERY == /^u?id=0$/</span><br /><br /><h2>Color Filters</h2><span>In addition to standard filters, color filters can be set by clicking the 'Colorize' button in the main tab. To add a filter press the add button and enter a filter as above, and optionally set the title, foreground and background colors. Changes are saved on pressing the close button. </span><br /><br /><h2>Tips and Tricks</h2><span>Filters can be generated by right clicking a log entry field, or right clicking within a request / response viewer with selected text.<br /></span>");

        scrollablePanel = new ScrollablePanel();
        scrollablePanel.setScrollableWidth( ScrollablePanel.ScrollableSizeHint.FIT );
        scrollablePanel.setLayout(new BorderLayout());
        scrollablePanel.add(overviewPane);

        contentPane.addTab("Overview", new JScrollPane(scrollablePanel));

        fieldPane = new JTextPane();
        fieldPane.setContentType("text/html");
        fieldPane.setEditable(false);
        fieldPane.setEditorKit(new HTMLEditorKit());
        //TODO: Rewrite below
        fieldPane.setText("<html><h1>Filter Fields</h1><h2>THIS INFO IS CURRENTLY OUT OF DATE AND NEEDS TO BE REWRITTEN. </h2><span>A number of fields are available to use from the requests within your filters. These are listed below.<br /><br /><b>Request</b> - The request body.<br /><br /><b>RequestHeaders</b> - The request line and associated headers.<br /><br /><b>Response</b> - The response body.<br /><br /><b>ResponseHeaders</b> - The status line and associated headers<br /><br /><b>Number</b> - Item table number, note this may change as old requests are deleted.<br /><br /><b>Tool</b> - Tool name [Target,Proxy,Spider,Scanner,Intruder,Repeater,Sequencer]<br /><br /><b>Host</b> - Host and Protocol (similar to the Proxy tab)<br /><br /><b>Method</b> - HTTP request method<br /><br /><b>Url</b> - Destination relative URL<br /><br /><b>Path</b> - Destination relative filepath<br /><br /><b>Query</b> - Query string used in GET requests<br /><br /><b>Params</b> - Indicates whether or not the request has GET or POST parameter(s) [True, False]<br /><br /><b>Status</b> - Numerical response code<br /><br /><b>ResponseLength</b> - Length of response<br /><br /><b>MimeType</b> - MIME / Response content type specified in header<br /><br /><b>UrlExtension</b> - Target page extension <br /><br /><b>Comment</b> - Editable comment<br /><br /><b>IsSSL</b> - Indicates whether or not the HTTP protocol is HTTPS [True, False]<br /><br /><b>NewCookies</b> - Shows any new cookies in the response <br /><br /><b>RequestTime</b> - Date and time of inital request (as received by burp)<br /><br /><b>ResponseTime</b> - Date and time of receiving the response (as received by burp)<br /><br /><b>ListenerInterface</b> - Shows the proxy listener interface for proxied requests<br /><br /><b>ClientIP</b> - Shows the client IP address when using the Proxy tab<br /><br /><b>ResponseContentType</b> - Shows the content-type header in the response<br /><br /><b>InferredType</b> - Shows the content type which was inferred by Burp [HTML,SCRIPT,PNG,GIF,...] via http message content<br /><br /><b>HasQueryStringParam</b> - Indicates whether or not the request has any querystring parameters [True, False]<br /><br /><b>HasBodyParam</b> - Indicates whether or not the request contains any POST parameters [True, False]<br /><br /><b>HasCookieParam</b> - Indicates whether or not the request has any Cookie parameters [True, False]<br /><br /><b>SentCookies</b> - Shows the cookies which was sent in the request<br /><br /><b>UsesCookieJar</b> - Compares the cookies with the cookie jar ones to see if any of them in use [Yes, No, Partially]<br /><br /><b>Protocol</b> - Shows the request protocol<br /><br /><b>Hostname</b> - Shows the request host name<br /><br /><b>TargetPort</b> - Shows the target port number<br /><br /><b>RequestContentType</b> - Shows the request content-type header<br /><br /><b>Referrer</b> - Shows the referer header<br /><br /><b>RequestLength</b> - Shows the request body length<br /><br /><b>HasSetCookies</b> - Indicates whether or not the response contains the set-cookie header<br /><br /><b>Regex1Req</b> - Custom regular expression for request header/body<br /><br /><b>Regex2Req</b> - Custom regular expression for request header/body<br /><br /><b>Regex3Req</b> - Custom regular expression for request header/body<br /><br /><b>Regex4Req</b> - Custom regular expression for request header/body<br /><br /><b>Regex5Req</b> - Custom regular expression for request header/body<br /><br /><b>Regex1Resp</b> - Custom regular expression for response header/body<br /><br /><b>Regex2Resp</b> - Custom regular expression for response header/body<br /><br /><b>Regex3Resp</b> - Custom regular expression for response header/body<br /><br /><b>Regex4Resp</b> - Custom regular expression for response header/body<br /><br /><b>Regex5Resp</b> - Custom regular expression for response header/body</span>");

        scrollablePanel = new ScrollablePanel();
        scrollablePanel.setScrollableWidth( ScrollablePanel.ScrollableSizeHint.FIT );
        scrollablePanel.setLayout(new BorderLayout());
        scrollablePanel.add(fieldPane);

        contentPane.addTab("Filter Fields", new JScrollPane(scrollablePanel));

        this.add(contentPane, BorderLayout.CENTER);
    }

//    @Override
//    public void setSize(Dimension d) {
//        super.setSize(d);
//        overviewPane.setSize(d);
//    }
}
