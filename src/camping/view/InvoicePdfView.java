package camping.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class InvoicePdfView extends AbstractPdfView {
	
	@Override
	protected void buildPdfDocument(Map model, Document document,
		PdfWriter writer, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		
		Chunk c = new Chunk("Cerisaie");
		document.add(new Paragraph(c));		
		document.add(new Paragraph("Route de la plage"));
		document.add(new Paragraph("33121 � CARCANS"));
		document.add(new Paragraph("Etoiles : **"));
		document.add(new Paragraph("T�l�phone : 05 - 67-78-56-45"));
		document.add(new Paragraph("Fax : 05 - 67 - 78 - 34 - 25"));
		
		document.add(Chunk.NEWLINE);
		Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC);
		c = new Chunk("Facture d'un s�jour", titleFont);
		document.add(new Paragraph(c));
		document.add(Chunk.NEWLINE);
		
		Paragraph p = new Paragraph();
		p.add(new Chunk("Num�ro de facture : "));
		p.add(new Chunk("SE34"));
		p.add("                   ");
		p.add(new Chunk("Date : "));
		p.add(new Chunk("15/08/2015"));
		document.add(p);
		
		document.add(Chunk.NEWLINE);
		Font smallTitle = FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD);
		c = new Chunk("Client : Merle", smallTitle);
		document.add(new Paragraph(c));
		
		Table table = new Table(2);
		table.setAlignment(Element.ALIGN_LEFT);
		table.addCell("Num�ro de s�jour");
		table.addCell("1");
		table.addCell("Num�ro d'emplacement");
		table.addCell("4");
		table.addCell("Type d'emplacement");
		table.addCell("Tente");
		document.add(table);
		
		document.add(Chunk.NEWLINE);
		c = new Chunk("* S�jour *", smallTitle);
		document.add(new Paragraph(c));
		
		table = new Table(4);
		table.setAlignment(Element.ALIGN_LEFT);
		table.addCell("Date de d�but");
		table.addCell("Date de fin");
		table.addCell("Nombre personnes");
		table.addCell("Prix/jour/personne");		
		table.addCell("01/01/2000");
		table.addCell("07/01/2000");
		table.addCell("4");
		table.addCell("20");
		document.add(table);
		
		table = new Table(2);
		table.setAlignment(Element.ALIGN_LEFT);
		table.addCell("Total � payer");
		table.addCell("560 �");
		document.add(table);
		
		document.close();
	}

}
