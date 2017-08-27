package br.com.feed.br.com.feed.utils;

import br.com.feed.model.Feed;
import br.com.feed.model.Item;
import br.com.feed.utils.CrawlerUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.springframework.http.HttpStatus.OK;

@RunWith(MockitoJUnitRunner.class)
public class CrawlerUtilsTest {


    @Test
    public void test_success() throws Exception {
        Feed feed = feedFactory();
        CrawlerUtils.setContent(feed);
        assertEquals(2,feed.getItem().size());
        assertEquals("Ford lança Ranger Sportrac por R$ 159.990",feed.getItem().get(0).getTitle());
        assertEquals("http://revistaautoesporte.globo.com/Noticias/noticia/2017/08/ford-lanca-ranger-sportrac-por-r-159990.html",feed.getItem().get(0).getLink());
        assertEquals(4,feed.getItem().get(0).getContent().size());
        assertEquals("text",feed.getItem().get(0).getContent().get(0).getType());
        assertEquals("A Ford aproveitou a feira agropecuária Expointer para apresentar a série especial Sportrac da Ranger, que já está no configurador do site da marca.",feed.getItem().get(0).getContent().get(0).getContent());
        assertEquals("image",feed.getItem().get(0).getContent().get(1).getType());
        assertEquals("http://s2.glbimg.com/ACOTgFuHX-_RkPE621aCkWf3Kww=/620x413/e.glbimg.com/og/ed/f/original/2017/08/25/rangerfrente.jpg",feed.getItem().get(0).getContent().get(1).getContent());
        assertEquals(3,feed.getItem().get(0).getContent().get(3).getContents().size());
        assertEquals("http://revistaautoesporte.globo.com/Analises/noticia/2016/03/teste-ford-ranger-limited.html",feed.getItem().get(0).getContent().get(3).getContents().get(0));

    }

    @Test
    public void test_fail() throws Exception {
        Feed feed = new Feed();
        CrawlerUtils.setContent(feed);
        assertNull(feed.getItem());

    }

    private Feed feedFactory() {
        Feed feed = new Feed();
        List<Item> itens = new ArrayList<>();

        Item item_1 = new Item();
        item_1.setTitle("Ford lança Ranger Sportrac por R$ 159.990");
        item_1.setDescription("<div class=\"foto componente_materia midia-largura-620\"><img alt=\"Ford Ranger Sportrac será lançada oficialmente na Expointer " +
                "(Foto: Divulgação)\" height=\"413\" id=\"239056\" src=\"http://s2.glbimg.com/ACOTgFuHX-_RkPE621aCkWf3Kww=/620x413/e.glbimg.com/og/ed/f/original/2017/08/25/rangerfrente.jpg\" " +
                "title=\"Ford Ranger Sportrac será lançada oficialmente na Expointer (Foto: Divulgação)\" width=\"620\" /><label class=\"foto-legenda\">Ford Ranger Sportrac ser&aacute; lan&ccedil;ada " +
                "oficialmente na Expointer (Foto: Divulga&ccedil;&atilde;o)</label></div><ul>\n" +
                " <li>\n" +
                " <a href=\"http://revistaautoesporte.globo.com/Noticias/noticia/2017/08/porsche-cria-maior-maquina-de-tecer-do-mundo-para-produzir-rodas-de-fibra-de-carbono-para-o-911-turbo.html\" target=\"_blank\">Porsche cria rodas exclusivas de fibra de carbono para o 911 Turbo</a></li>\n" +
                " <li>\n" +
                " <a href=\"http://revistaautoesporte.globo.com/Noticias/noticia/2017/08/porsche-inicia-vendas-do-cayenne-platinum-edition-no-brasil.html\" target=\"_blank\">Porsche inicia vendas do Cayenne Platinum Edition no Brasil</a></li>\n" +
                " </ul><p>A <a href=\"http://revistaautoesporte.globo.com/carros/ford/\">Ford</a> aproveitou a feira " +
                "agropecu&aacute;ria Expointer para apresentar a s&eacute;rie especial Sportrac da Ranger, que j&aacute; est&aacute; " +
                "no <a href=\"https://www.ford.com.br/compre-o-seu/monte-o-seu.html/?v=RANGER&amp;n=Nova_Ranger_FBR&amp;u=P&amp;l=&amp;c=&amp;y=2017&amp;vc=Pick-Ups&amp;intcmp=bb-fbr-vhp-ford%20ranger-fbr--return\">configurador do site da marca</a>." +
                "<div class=\"saibamais componente_materia expandido\">\t<strong>saiba mais</strong>\t<ul>\t\t<li>\t\t\t<a href=\"http://revistaautoesporte.globo.com/Analises/noticia/2016/03/teste-ford-ranger-limited.html\">Testamos: como anda a Ford Ranger Limited com motor de 200 cv</a></li>\t\t<li>\t\t\t<a href=\"http://revistaautoesporte.globo.com/Noticias/noticia/2017/07/ford-ranger-fica-ate-r-2400-mais-cara-na-linha-2018.html\">Mercado: Ford Ranger fica mais cara com o lan&ccedil;amento da linha 2018</a></li>\t\t<li>\t\t\t<a href=\"http://revistaautoesporte.globo.com/Noticias/noticia/2016/10/ford-confirma-ranger-wildtrack-para-o-salao-de-sao-paulo.html\">Outra vers&atilde;o especial: Ford apresenta Ranger Wildtrack no Sal&atilde;o do Autom&oacute;vel</a></li>\t</ul></div>");
        item_1.setLink("http://revistaautoesporte.globo.com/Noticias/noticia/2017/08/ford-lanca-ranger-sportrac-por-r-159990.html");
        itens.add(item_1);

        Item item_2 = new Item();
        item_2.setTitle("Novo Porsche Cayenne tem primeiras fotos vazadas antes do lançamento");
        item_2.setDescription("<div class=\"foto componente_materia midia-largura-620\">t<img alt=\"Porsche Cayenne 2018 (Foto: Divulgação)\" " +
                "src=\"http://s2.glbimg.com/tY8UsKr2k9Oqyf-rJy0EBd8hwTs=/620x413/e.glbimg.com/og/ed/f/original/2017/08/25/porsche-cayenne-2018-autoesporte-04.jpg\" title=\"Porsche Cayenne 2018 (Foto: Divulgação)\" width=\"620\" /><label class=\"foto-legenda\">SUV ter&aacute; " +
                        "nova plataforma, razoavelmente mais leve (Foto: Divulga&ccedil;&atilde;o)</label></div><p>&nbsp;</p><p><strong>Ainda faltam alguns dias para a revela&ccedil;&atilde;o oficial da nova gera&ccedil;&atilde;o do Cayenne, mas a revista inglesa <em>Auto Express</em> " +
                        "conseguiu as primeiras imagens (aparentemente reais) do SUV de luxo, que ser&aacute; revelado pela f&aacute;brica de Stuttgart na pr&oacute;xima ter&ccedil;a-feira (29)</strong>. A estreia para o p&uacute;blico ocorrer&aacute; em duas semanas, no <strong>Sal&atilde;o " +
                        "do Autom&oacute;vel de Frankfurt</strong>.</p><div class=\"foto componente_materia midi");
        item_2.setLink("http://revistaautoesporte.globo.com/Noticias/noticia/2017/08/novo-porsche-cayenne-tem-primeiras-fotos-vazadas-antes-do-lancamento.html");
        itens.add(item_2);

        feed.setItem(itens);
        return feed;

    }

}


