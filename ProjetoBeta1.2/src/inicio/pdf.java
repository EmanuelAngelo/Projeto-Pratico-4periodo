package inicio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class pdf {
	
	public pdf(Document doc , OutputStream os, int mes, int ano) throws DocumentException, MalformedURLException, IOException, SQLException{
		
		try {
			String sql = "";
			PreparedStatement ps = null;
			ResultSet rs = null;
			doc = new Document(PageSize.A4, 10, 10, 72, 72); //formato do pdf e suas dimensões //
		    os = new FileOutputStream("C://Users//Gustavo//Desktop//relatorio.pdf");//local salvo//
		    PdfWriter.getInstance(doc, os);
		    doc.open();//abrindo pdf para edição//
		    doc.add(new Chunk(""));
		    Font f = new Font(FontFamily.UNDEFINED, 20, Font.NORMAL);//fonte//
		    Paragraph p = new Paragraph("Unidade de Ensino Superior Dom Bosco",f);//parágrafo inicial//
		    p.setAlignment(Element.ALIGN_CENTER);
		    p.setSpacingAfter(20); //espacamento abaixo do parágrafo//
		    Paragraph p0 = new Paragraph("Plantão Tira-Dúvidas",f);
		    p0.setAlignment(Element.ALIGN_CENTER);
		    p0.setSpacingAfter(10);
		    Paragraph p1 = new Paragraph("Descrição de agendamentos atendidos ");//parágrafo relatorio//
		    p1.setAlignment(Element.ALIGN_CENTER);// alinhamento do paragrafo//
		    p1.setSpacingAfter(20);
		    Image img = Image.getInstance("logo_undb.png");//imagem undb//
		    img.setAlignment(Element.ALIGN_CENTER);
		    
		    
		    PdfPTable table = new PdfPTable(new float[] {0.3f,0.3f,0.3f,0.3f,0.4f,0.4f }); // tabela agendamentos//
		    table.setSpacingAfter(20);
		    
		    PdfPCell nome = new PdfPCell(new Paragraph("Nome"));//colunas//
		    PdfPCell matricula = new PdfPCell(new Paragraph("Matricula"));
		    PdfPCell curso = new PdfPCell(new Paragraph("Curso"));
		    PdfPCell data = new PdfPCell(new Paragraph("Data"));
		    PdfPCell assunto = new PdfPCell(new Paragraph("Assunto"));
		    PdfPCell descricao = new PdfPCell(new Paragraph("Descrição"));
		    nome.setColspan(1);
		    matricula.setColspan(1);
		    curso.setColspan(1); 
		    table.addCell(nome); //adicionando colunas na tabela//
		    table.addCell(matricula);
		    table.addCell(curso);
		    table.addCell(data);
		    table.addCell(assunto);
		    table.addCell(descricao);
		    
		    sql = "Select* from prof where situacao = 'Concluído'";// pegando dados do banco e colocando na tabela//
		    ps = Conector.getConexao().prepareStatement(sql);
		    rs = ps.executeQuery();
		    String d = "";
		    while(rs.next()){
		    	d = "";
		    	LocalDate localmes = null;
		    	LocalDate localano = null;
		    	d+=rs.getDate("data_agen");
		    	localmes = LocalDate.parse(d);
		    	localano = LocalDate.parse(d);
		    	if(localmes.getMonthValue()== mes && localano.getYear()==ano){
		    		d="";
			    	d+=rs.getDate("data_agen");
			    	table.addCell(rs.getString("nome"));
				    table.addCell(rs.getString("matricula"));
				    table.addCell(rs.getString("curso"));
				    table.addCell(d);
				    table.addCell(rs.getString("assunto"));
				    table.addCell(rs.getString("descricao"));
		    	}
		    }

		    Paragraph p2 = new Paragraph("Número de agendamentos concluídos por assunto ");// parágrafo//
		    p2.setAlignment(Element.ALIGN_CENTER);
		    p2.setSpacingAfter(20);
		    
		    PdfPTable table2 = new PdfPTable(2); // tabela 2 de agendamentos concluídos por assunto (gráfico)//
		    table2.setSpacingAfter(20);
		    PdfPCell duvida = new PdfPCell(new Paragraph("Assunto"));//coluna//
		    duvida.setHorizontalAlignment(Element.ALIGN_CENTER);
		    PdfPCell num = new PdfPCell(new Paragraph("Nº de agendamentos"));//coluna//
		    num.setHorizontalAlignment(Element.ALIGN_CENTER);
		    table2.addCell(duvida);
		    table2.addCell(num);
		    sql = "select assunto, sum(soma) from grafico  where situacao = 'Concluído' group by assunto";// pegando dados do banco//
		    ps = Conector.getConexao().prepareStatement(sql);
		    rs = ps.executeQuery();
		    
		    while(rs.next()){
		    	table2.addCell(rs.getString("assunto"));
		    	table2.addCell(rs.getString("sum(soma)"));
		    }
		    
		    Paragraph p3 = new Paragraph("Número de Agendamentos Concluídos por professor ");// parágrafo //
		    p3.setAlignment(Element.ALIGN_CENTER);
		    p3.setSpacingAfter(20);
		    PdfPTable table3 = new PdfPTable(2);// tabela 3 numero de retornos por assunto//
		    table3.setSpacingAfter(20);
		    PdfPCell prof = new PdfPCell(new Paragraph("Professor"));
		    prof.setHorizontalAlignment(Element.ALIGN_CENTER);
		    

		    PdfPCell num2 = new PdfPCell(new Paragraph("Nº de atendimentos"));// coluna tabela3//
		    num2.setHorizontalAlignment(Element.ALIGN_CENTER);
		    table3.addCell(prof);
		    table3.addCell(num2);
		    sql = "select nome_prof, sum(soma) from grafico  where situacao = 'Concluído' group by nome_prof";// pegando dados do banco //
		    ps = Conector.getConexao().prepareStatement(sql);
		    rs = ps.executeQuery();
		    while(rs.next()){
		    	table3.addCell(rs.getString("nome_prof"));
		    	table3.addCell(rs.getString("sum(soma)"));
		    }
		    Paragraph p4 = new Paragraph("Número de Agendamentos Concluídos por curso ");// parágrafo //
		    p4.setAlignment(Element.ALIGN_CENTER);
		    p4.setSpacingAfter(20);
		    PdfPTable table4 = new PdfPTable(2);// tabela 3 numero de retornos por assunto//
		    table4.setSpacingAfter(20);
		    PdfPCell curs = new PdfPCell(new Paragraph("Curso"));
		    curs.setHorizontalAlignment(Element.ALIGN_CENTER);
		    

		    PdfPCell num3 = new PdfPCell(new Paragraph("Nº de atendimentos"));// coluna tabela3//
		    num3.setHorizontalAlignment(Element.ALIGN_CENTER);
		    table4.addCell(curs);
		    table4.addCell(num2);
		    sql = "select curso, sum(soma) from grafico  where situacao = 'Concluído' group by curso";// pegando dados do banco //
		    ps = Conector.getConexao().prepareStatement(sql);
		    rs = ps.executeQuery();
		    while(rs.next()){
		    	table4.addCell(rs.getString("curso"));
		    	table4.addCell(rs.getString("sum(soma)"));
		    }
		    
		    Paragraph p5 = new Paragraph("Dúvidas mais frequentes por professor ");// parágrafo //
		    p5.setAlignment(Element.ALIGN_CENTER);
		    p5.setSpacingAfter(20);
		    PdfPTable table5 = new PdfPTable(2);// tabela 3 numero de retornos por assunto//
		    table5.setSpacingAfter(20);
		    PdfPCell prof1 = new PdfPCell(new Paragraph("Professor"));
		    prof1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    

		    PdfPCell num4 = new PdfPCell(new Paragraph("Nº de atendimentos"));// coluna tabela3//
		    num4.setHorizontalAlignment(Element.ALIGN_CENTER);
		    table5.addCell(prof1);
		    table5.addCell(num4);
		    sql = "select nome_prof, sum(soma),assunto from grafico where situacao = 'Concluído' group by nome_prof";// pegando dados do banco //
		    ps = Conector.getConexao().prepareStatement(sql);
		    rs = ps.executeQuery();
		    while(rs.next()){
		    	table5.addCell(rs.getString("nome_prof"));
		    	table5.addCell(rs.getString("assunto"));
		    }
		    
		    Paragraph p6 = new Paragraph("Número de Retornos por assunto ");// parágrafo //
		    p6.setAlignment(Element.ALIGN_CENTER);
		    p6.setSpacingAfter(20);
		    PdfPTable table6 = new PdfPTable(2);// tabela 3 numero de retornos por assunto//
		    table6.setSpacingAfter(20);
		    PdfPCell assunto2 = new PdfPCell(new Paragraph("Assunto"));
		    assunto2.setHorizontalAlignment(Element.ALIGN_CENTER);
		    table6.addCell(assunto2);
		    table6.addCell(num4);
		    sql = "select assunto,count(nome) from prof where status = 'Retorno' group by assunto";// pegando dados do banco //
		    ps = Conector.getConexao().prepareStatement(sql);
		    rs = ps.executeQuery();
		    while(rs.next()){
		    	table6.addCell(rs.getString("assunto"));
		    	table6.addCell(rs.getString("count(nome)"));
		    }
		    
		    
		    //adicionando todos os componentes no documento pdf//
		    doc.add(img);
		    doc.add(p);
		    doc.add(p0);
		    doc.add(p2);
		    doc.add(table2);
		    doc.add(p3);
		    doc.add(table3);
		    doc.add(p4);
		    doc.add(table4);
		    doc.add(p5);
		    doc.add(table5);
		    doc.add(p6);
		    doc.add(table6);
		    doc.add(p1);
		    doc.add(table);
		        } finally {
		//fechamento do documento //
		            if (doc != null) {
		                doc.close();
		
		            }
		
		            if (os != null) {
		
		               os.close();
		
		            }
		
		        }

	}
	
}
