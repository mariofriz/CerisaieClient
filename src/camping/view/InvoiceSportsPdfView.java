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

public class InvoiceSportsPdfView extends AbstractPdfView {
	
	@Override
	protected void buildPdfDocument(Map model, Document document,
		PdfWriter writer, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		
		Chunk c = new Chunk("Cerisaie");
		document.add(new Paragraph(c));		
		document.add(new Paragraph("Route de la plage"));
		document.add(new Paragraph("33121 – CARCANS"));
		document.add(new Paragraph("Etoiles : **"));
		document.add(new Paragraph("Téléphone : 05 - 67-78-56-45"));
		document.add(new Paragraph("Fax : 05 - 67 - 78 - 34 - 25"));
		
		document.add(Chunk.NEWLINE);
		Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC);
		c = new Chunk("Facture des prestations sportives", titleFont);
		document.add(new Paragraph(c));
		document.add(Chunk.NEWLINE);
		
		Paragraph p = new Paragraph();
		p.add(new Chunk("Numéro de facture : "));
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
		table.addCell("Numéro de séjour");
		table.addCell("1");
		table.addCell("Numéro d'emplacement");
		table.addCell("4");
		table.addCell("Type d'emplacement");
		table.addCell("Tente");
		document.add(table);
		
		document.add(Chunk.NEWLINE);
		c = new Chunk("* Prestations sportives *", smallTitle);
		document.add(new Paragraph(c));
		
		table = new Table(5);
		table.setAlignment(Element.ALIGN_LEFT);
		table.addCell("Date de l'activité");
		table.addCell("Nom du sport");
		table.addCell("Prix / Unité");
		table.addCell("Nombre d'unité");		
		table.addCell("Montant");
		
		table.addCell("03/07/2000");
		table.addCell("Canoë");
		table.addCell("10");
		table.addCell("2");		
		table.addCell("20");
		table.addCell("03/07/2000");
		table.addCell("Canoë");
		table.addCell("10");
		table.addCell("2");		
		table.addCell("20");
		table.addCell("03/07/2000");
		table.addCell("Canoë");
		table.addCell("10");
		table.addCell("2");		
		table.addCell("20");
		document.add(table);
		
		table = new Table(2);
		table.setAlignment(Element.ALIGN_LEFT);
		table.addCell("Total à payer");
		table.addCell("60 €");
		document.add(table);
		
		document.close();
	}

}
