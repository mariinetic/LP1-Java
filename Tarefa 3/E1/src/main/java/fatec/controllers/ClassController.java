package fatec.controllers;

import fatec.classes.Cachorro;
import fatec.classes.Flores;
import fatec.classes.JogadorasDeVolei;
import fatec.classes.KpopSingers;
import fatec.classes.Planeta;
import fatec.classes.Refrigerante;
import fatec.classes.Salgadinhos;
import fatec.classes.Sanrio;
import fatec.classes.TiposDeCabelo;
import fatec.classes.TrabalhadoresDeEscritorio;
import fatec.utils.mbox;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ClassController {

    //#region Flores

    @FXML
    private TextField txtFloresNome;
    @FXML
    private TextField txtFloresCor;
    @FXML
    private TextField txtFloresTipo;
    @FXML
    private Button btnFloresCriar;
    @FXML
    private Button btnFloresVerCadastro;
    @FXML
    private Button btnFloresMurchar;
    @FXML
    private Button btnFloresFlorescer;

    private Flores flor;

    @FXML
    private void FloresCriar() {
        String nome = txtFloresNome.getText();
        String cor = txtFloresCor.getText();
        String tipo = txtFloresTipo.getText();

        flor = new Flores(nome, cor, tipo);
        mbox.ShowMessageBox("Flor", "Flor cadastrada com sucesso");
    }

    @FXML
    private void FloresVerCadastro() {
        String message = "Nome: " + flor.getNome() + 
                        "\nCor: " + flor.getCor() + 
                        "\nTipo: " + flor.getTipo();

        mbox.ShowMessageBox("Flor cadastrada", message);
    }

    @FXML
    private void FlorMurchar() {
        String title = flor.Murchar();
        String gifPath = getClass().getResource("/fatec/gifs/flor-murchar.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    @FXML
    private void FlorFlorescer() {
        String title = flor.Florescer();
        String gifPath = getClass().getResource("/fatec/gifs/flor-florescer.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    //#endregion Flores

    //#region Kpop

    @FXML
    private TextField txtKpopNome;
    @FXML
    private TextField txtKpopIdade;
    @FXML
    private TextField txtKpopGrupo;
    @FXML
    private TextField txtKpopAltura;
    @FXML
    private Button btnKpopCriar;
    @FXML
    private Button btnKpopVerCadastro;
    @FXML
    private Button btnKpopCantar;
    @FXML
    private Button btnKpopDancar;

    private KpopSingers cantora;

    @FXML
    private void KpopCriar() {
        String nome = txtKpopNome.getText();
        int idade = Integer.parseInt(txtKpopIdade.getText());
        String grupo = txtKpopGrupo.getText();
        double altura = Double.parseDouble(txtKpopAltura.getText());

        cantora = new KpopSingers(nome, idade, grupo, altura);
        mbox.ShowMessageBox("Cantora K-Pop", "Cantora cadastrada com sucesso");
    }

    @FXML
    private void KpopVerCadastro() {
        String message = "Nome: " + cantora.getNome() + 
                        "\nIdade: " + cantora.getIdade() + 
                        "\nGrupo: " + cantora.getGrupo() + 
                        "\nAltura: " + cantora.getAltura();

        mbox.ShowMessageBox("Cadastro da Cantora", message);
    }

    @FXML
    private void KpopCantar() {
        String title = cantora.Cantar();
        String gifPath = getClass().getResource("/fatec/gifs/kpop-cantar.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    @FXML
    private void KpopDancar() {
        String title = cantora.Dancar();
        String gifPath = getClass().getResource("/fatec/gifs/kpop-dancar.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    //#endregion Kpop

    //#region Cabelos

    @FXML
    private TextField txtCabeloTipo;
    @FXML
    private TextField txtCabeloCor;
    @FXML
    private TextField txtCabeloComprim;
    @FXML
    private CheckBox chkCabeloNatural;
    @FXML
    private Button btnCabeloCriar;
    @FXML
    private Button btnCabeloVerCadastro;
    @FXML
    private Button btnCabeloCortar;
    @FXML
    private Button btnCabeloPentear;

    private TiposDeCabelo cabelo;

    @FXML
    private void CabeloCriar() {
        String tipo = txtCabeloTipo.getText();
        String cor = txtCabeloCor.getText();
        double comprimento = Double.parseDouble(txtCabeloComprim.getText());
        boolean natural = chkCabeloNatural.isSelected();

        cabelo = new TiposDeCabelo(tipo, cor, comprimento, natural);
        mbox.ShowMessageBox("Cabelos", "Cabelo cadastrado com sucesso");
    }

    @FXML
    private void CabeloVerCadastro() {
        String message = "Tipo: " + cabelo.getTipo() +
                         "\nCor: " + cabelo.getCor() +
                         "\nComprimento: " + cabelo.getComprimento() +
                         "\nNatural: " + (cabelo.isNatural() ? "Sim" : "Não");
        mbox.ShowMessageBox("Cabelo cadastrado", message);
    }

    @FXML
    private void CabeloCortar() {

        String title = cabelo.Cortar();
        String gifPath = getClass().getResource("/fatec/gifs/cabelo-cortar.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    @FXML
    private void CabeloPentear() {
        String title = cabelo.Pentear();
        String gifPath = getClass().getResource("/fatec/gifs/cabelo-pentear.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    //#endregion Cabelos

    //#region Cachorro

    @FXML
    private TextField txtCachorroNome;
    @FXML
    private TextField txtCachorroRaca;
    @FXML
    private TextField txtCachorroPeso;
    @FXML
    private TextField txtCachorroIdade;
    @FXML
    private Button btnCachorroCriar;
    @FXML
    private Button btnCachorroVerCadastro;
    @FXML
    private Button btnCachorroCorrer;
    @FXML
    private Button btnCachorroLatir;

    private Cachorro cachorro;

    @FXML
    private void CachorroCriar() {
        String nome = txtCachorroNome.getText();
        String raca = txtCachorroRaca.getText();
        double peso = Double.parseDouble(txtCachorroPeso.getText());
        int idade = Integer.parseInt(txtCachorroIdade.getText());

        cachorro = new Cachorro(nome, raca, peso, idade);
        mbox.ShowMessageBox("Cachorro", "Cachorro cadastrado com sucesso");
    }

    @FXML
    private void CachorroVerCadastro() {
        String message = "Nome: " + cachorro.getNome() +
                        "\nRaça: " + cachorro.getRaca() +
                        "\nPeso: " + cachorro.getPeso() +
                        "\nIdade: " + cachorro.getIdade();
        mbox.ShowMessageBox("Cadastro do Cachorro", message);
    }

    @FXML
    private void CachorroCorrer() {
        String title = cachorro.Correr();
        String gifPath = getClass().getResource("/fatec/gifs/cachorro-correr.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    @FXML
    private void CachorroLatir() {
        String title = cachorro.Latir();
        String gifPath = getClass().getResource("/fatec/gifs/cachorro-latir.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    //#endregion Cachorro

    //#region Planetas

    @FXML
    private TextField txtPlanetaNome;
    @FXML
    private TextField txtPlanetaMassa;
    @FXML
    private TextField txtPlanetaDiametro;
    @FXML
    private TextField txtPlanetaDistSol;
    @FXML
    private CheckBox chkPlanetaAnel;
    @FXML
    private Button btnPlanetaCriar;
    @FXML
    private Button btnPlanetaVerCadastro;
    @FXML
    private Button btnPlanetaGirar;
    @FXML
    private Button btnPlanetaOrbitar;

    private Planeta planeta;

    @FXML
    private void PlanetaCriar() {
        String nome = txtPlanetaNome.getText();
        double massa = Double.parseDouble(txtPlanetaMassa.getText());
        double diametro = Double.parseDouble(txtPlanetaDiametro.getText());
        double distSol = Double.parseDouble(txtPlanetaDistSol.getText());
        boolean temAnel = chkPlanetaAnel.isSelected();

        planeta = new Planeta(nome, massa, diametro, distSol, temAnel);
        mbox.ShowMessageBox("Planeta", "Planeta cadastrado com sucesso");
    }

    @FXML
    private void PlanetaVerCadastro() {
        String message = "Nome: " + planeta.getNome() +
                        "\nMassa: " + planeta.getMassa() +
                        "\nDiâmetro: " + planeta.getDiametro() +
                        "\nDistância do Sol: " + planeta.getDistanciaDoSol() +
                        "\nTem anel: " + (planeta.isTemAnel() ? "Sim" : "Não");
        mbox.ShowMessageBox("Cadastro do Planeta", message);
    }

    @FXML
    private void PlanetaGirar() {
        String title = planeta.Girar();
        String gifPath = getClass().getResource("/fatec/gifs/planeta-girar.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    @FXML
    private void PlanetaOrbitar() {
        String title = planeta.Orbitar();
        String gifPath = getClass().getResource("/fatec/gifs/planeta-orbitar.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    //#endregion Planetas

    //#region Refrigerante

    @FXML
    private TextField txtRefriNome;
    @FXML
    private TextField txtRefriSabor;
    @FXML
    private TextField txtRefriMarca;
    @FXML
    private TextField txtRefriVolume;
    @FXML
    private CheckBox chkRefriDiet;
    @FXML
    private Button btnRefriCriar;
    @FXML
    private Button btnRefriVerCadastro;
    @FXML
    private Button btnRefriAbrir;
    @FXML
    private Button btnRefriServir;

    private Refrigerante refrigerante;

    private boolean estaAberto = false;

    @FXML
    private void RefriCriar() {
        String nome = txtRefriNome.getText();
        String sabor = txtRefriSabor.getText();
        String marca = txtRefriMarca.getText();
        int volume = Integer.parseInt(txtRefriVolume.getText());
        boolean isDiet = chkRefriDiet.isSelected();
        estaAberto = false;

        refrigerante = new Refrigerante(nome, sabor, marca, volume, isDiet);
        mbox.ShowMessageBox("Refrigerante", "Refrigerante cadastrado com sucesso");
    }

    @FXML
    private void RefriVerCadastro() {
        String message = "Nome: " + refrigerante.getNome() +
                        "\nSabor: " + refrigerante.getSabor() +
                        "\nMarca: " + refrigerante.getMarca() +
                        "\nVolume: " + refrigerante.getVolumeML() +
                        "\nÉ diet: " + (refrigerante.isDiet() ? "Sim" : "Não");
        mbox.ShowMessageBox("Cadastro do Refrigerante", message);
    }

    @FXML
    private void RefriAbrir() {
        String title = refrigerante.Abrir();
        String gifPath = getClass().getResource("/fatec/gifs/refri-abrir.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
        estaAberto = true;
    }

    @FXML
    private void RefriServir() {
        if (estaAberto == false){
            mbox.ShowMessageBox("Refrigerante", "Refrigerante está fechado");
            return;
        }
        String title = refrigerante.Servir();
        String gifPath = getClass().getResource("/fatec/gifs/refri-servir.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    //#endregion Refrigerante

    //#region Sanrio

    @FXML
    private TextField txtSanrioNome;
    @FXML
    private TextField txtSanrioComidaFav;
    @FXML
    private TextField txtSanrioCor;
    @FXML
    private TextField txtSanrioIdade;
    @FXML
    private Button btnSanrioCriar;
    @FXML
    private Button btnSanrioVerCadastro;
    @FXML
    private Button btnSanrioBrincar;
    @FXML
    private Button btnSanrioCozinhar;

    private Sanrio personagemSanrio;

    @FXML
    private void SanrioCriar() {
        String nome = txtSanrioNome.getText();
        String comidaFavorita = txtSanrioComidaFav.getText();
        String cor = txtSanrioCor.getText();
        int idade = Integer.parseInt(txtSanrioIdade.getText());

        personagemSanrio = new Sanrio(nome, comidaFavorita, cor, idade);
        mbox.ShowMessageBox("Personagem Sanrio", "Personagem cadastrado com sucesso");
    }

    @FXML
    private void SanrioVerCadastro() {
        String message = "Nome: " + personagemSanrio.getNome() +
                        "\nComida Favorita: " + personagemSanrio.getComidaFav() +
                        "\nCor: " + personagemSanrio.getCor() +
                        "\nIdade: " + personagemSanrio.getIdade();
        mbox.ShowMessageBox("Cadastro do Personagem Sanrio", message);
    }

    @FXML
    private void SanrioBrincar() {
        String title = personagemSanrio.Brincar();
        String gifPath = getClass().getResource("/fatec/gifs/sanrio-brincar.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    @FXML
    private void SanrioCozinhar() {
        String title = personagemSanrio.Cozinhar();
        String gifPath = getClass().getResource("/fatec/gifs/sanrio-cozinhar.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    //#endregion Sanrio

    //#region Jogadoras de Vôlei

    @FXML
    private TextField txtVoleiNome;
    @FXML
    private TextField txtVoleiPos;
    @FXML
    private TextField txtVoleiAltura;
    @FXML
    private TextField txtVoleiNumero;
    @FXML
    private Button btnVoleiCriar;
    @FXML
    private Button btnVoleiVerCadastro;
    @FXML
    private Button btnVoleiAtacar;
    @FXML
    private Button btnVoleiSacar;
    @FXML
    private Button btnVoleiBloquear;

    private JogadorasDeVolei jogadora;

    @FXML
    private void VoleiCriar() {
        String nome = txtVoleiNome.getText();
        String posicao = txtVoleiPos.getText();
        double altura = Double.parseDouble(txtVoleiAltura.getText());
        int numero = Integer.parseInt(txtVoleiNumero.getText());

        jogadora = new JogadorasDeVolei(nome, posicao, altura, numero);
        mbox.ShowMessageBox("Jogadora de Vôlei", "Jogadora cadastrada com sucesso");
    }

    @FXML
    private void VoleiVerCadastro() {
        String message = "Nome: " + jogadora.getNome() +
                        "\nPosição: " + jogadora.getPosicao() +
                        "\nAltura: " + jogadora.getAltura() +
                        "\nNúmero: " + jogadora.getNumeroCamisa();
        mbox.ShowMessageBox("Cadastro da Jogadora de Vôlei", message);
    }

    @FXML
    private void VoleiAtacar() {
        String title = jogadora.Atacar();
        String gifPath = getClass().getResource("/fatec/gifs/volei-atacar.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    @FXML
    private void VoleiSacar() {
        String title = jogadora.Sacar();
        String gifPath = getClass().getResource("/fatec/gifs/volei-sacar.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    @FXML
    private void VoleiBloquear() {
        String title = jogadora.Bloquear();
        String gifPath = getClass().getResource("/fatec/gifs/volei-bloquear.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    //#endregion Jogadoras de Vôlei

    // #region Escritório

    @FXML
    private TextField txtOfficeNome;
    @FXML
    private TextField txtOfficeSalario;
    @FXML
    private TextField txtOfficeCargo;
    @FXML
    private Button btnOfficeCriar;
    @FXML
    private Button btnOfficeVerCadastro;
    @FXML
    private Button btnOfficeTrabalhar;
    @FXML
    private Button btnOfficeReuniao;

    private TrabalhadoresDeEscritorio escritorio;

    @FXML
    private void OfficeCriar() {
        String nome = txtOfficeNome.getText();
        String cargo = txtOfficeCargo.getText();
        double salario = Double.parseDouble(txtOfficeSalario.getText());

        escritorio = new TrabalhadoresDeEscritorio(nome, cargo, salario);
        mbox.ShowMessageBox("Escritório", "Cadastro realizado com sucesso");
    }

    @FXML
    private void OfficeVerCadastro() {
        String message = "Nome: " + escritorio.getNome() +
                        "\nSalário: " + escritorio.getSalario() +
                        "\nCargo: " + escritorio.getCargo();
        mbox.ShowMessageBox("Cadastro do Escritório", message);
    }

    @FXML
    private void OfficeTrabalhar() {
        String title = escritorio.Trabalhar();
        String gifPath = getClass().getResource("/fatec/gifs/office-trabalhar.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    @FXML
    private void OfficeReuniao() {
        String title = escritorio.ParticiparDeReuniao();
        String gifPath = getClass().getResource("/fatec/gifs/office-reuniao.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    //#endregion Escritório

    //#region Salgadinho

    @FXML
    private TextField txtSalgadSabor;
    @FXML
    private TextField txtSalgadPeso;
    @FXML
    private TextField txtSalgadQuant;
    @FXML
    private Button btnSalgadCriar;
    @FXML
    private Button btnSalgadVerCadastro;
    @FXML
    private Button btnSalgadComer;
    @FXML
    private Button btnSalgadAdd;

    private Salgadinhos salgadinho;

    @FXML
    private void SalgadCriar() {
        String sabor = txtSalgadSabor.getText();
        double peso = Double.parseDouble(txtSalgadPeso.getText());
        int quantidade = Integer.parseInt(txtSalgadQuant.getText());

        salgadinho = new Salgadinhos(sabor, peso, quantidade);
        mbox.ShowMessageBox("Salgadinho", "Salgadinho criado com sucesso");
    }

    @FXML
    private void SalgadVerCadastro() {
        String message = "Sabor: " + salgadinho.getSabor() +
                        "\nPeso: " + salgadinho.getPeso() +
                        "\nQuantidade: " + salgadinho.getQtnde();
        mbox.ShowMessageBox("Cadastro do Salgadinho", message);
    }

    @FXML
    private void SalgadComer() {
        String title = salgadinho.Comer();
        if (title == null) {
            mbox.ShowMessageBox("Salgadinho", "Você não tem salgadinho para comer");
            return;
        }
        String gifPath = getClass().getResource("/fatec/gifs/salgad-comer.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    @FXML
    private void SalgadAdd() {
        String title = salgadinho.Add();
        String gifPath = getClass().getResource("/fatec/gifs/salgad-add.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    // #endregion Salgadinho

}
