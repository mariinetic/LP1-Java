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
import fatec.db.CachorroDAO;
import fatec.db.FloresDAO;
import fatec.db.JogadorasDeVoleiDAO;
import fatec.db.KpopSingersDAO;
import fatec.db.PlanetaDAO;
import fatec.db.RefrigeranteDAO;
import fatec.db.SalgadinhosDAO;
import fatec.db.SanrioDAO;
import fatec.db.TiposDeCabeloDAO;
import fatec.db.TrabalhadoresDeEscritorioDAO;
import fatec.utils.mbox;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private Button btnFloresMurchar;
    @FXML
    private Button btnFloresFlorescer;

    private Flores florSelecionada;

    @FXML
    private TableView<Flores> tableFlores;

    @FXML
    private TableColumn<Flores, String> FloresNomeColumn;
    @FXML
    private TableColumn<Flores, String> FloresCorColumn;
    @FXML
    private TableColumn<Flores, String> FloresTipoColumn;

    @FXML
    public void tbSelectedFlores() {
        FloresNomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        FloresCorColumn.setCellValueFactory(new PropertyValueFactory<>("cor"));
        FloresTipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        FloresPreencherTableView();
    }

    @FXML
    private void FloresCriar() {
        String nome = txtFloresNome.getText();
        String cor = txtFloresCor.getText();
        String tipo = txtFloresTipo.getText();

        try {
            Flores flor = new Flores(nome, cor, tipo);
            FloresDAO.inserir(flor);
            mbox.ShowMessageBox("Flor", "Flor cadastrada com sucesso");
            FloresPreencherTableView();
        } catch (Exception e) {

        }
    }

    @FXML
    private void FloresEditar() {
        String nome = txtFloresNome.getText();
        String cor = txtFloresCor.getText();
        String tipo = txtFloresTipo.getText();

        try {
            System.out.println(String.valueOf(florSelecionada.getNome()));
            Flores flor = new Flores(florSelecionada.getId(), nome, cor, tipo);
            FloresDAO.atualizar(flor);
            mbox.ShowMessageBox("Flor", "Flor editada com sucesso");
            FloresPreencherTableView();
        } catch (Exception e) {
        }
    }

    @FXML
    private void FloresExcluir() {
        try {
            FloresDAO.excluir(florSelecionada.getId());
            mbox.ShowMessageBox("Flor", "Flor excluida com sucesso");
            FloresPreencherTableView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void FlorMurchar() {
        try {
            String title = florSelecionada.Murchar();
            String gifPath = getClass().getResource("/gifs/flor-murchar.gif").toExternalForm();
            mbox.ShowGifMessageBox(title, gifPath);
        } catch (Exception e) {
        }
    }

    @FXML
    private void FlorFlorescer() {
        try {
            String title = florSelecionada.Florescer();
            String gifPath = getClass().getResource("/gifs/flor-florescer.gif").toExternalForm();
            mbox.ShowGifMessageBox(title, gifPath);
        } catch (Exception e) {
        }
    }

    @FXML
    public void FloresClickTableView() {
        FloresLimparCampos();
        florSelecionada = tableFlores.getSelectionModel().getSelectedItem();
        txtFloresNome.setText(florSelecionada.getNome());
        txtFloresCor.setText(String.valueOf(florSelecionada.getCor()));
        txtFloresTipo.setText(String.valueOf(florSelecionada.getTipo()));
    }

    @FXML
    private void FloresPreencherTableView() {
        try {
            tableFlores.setItems(FXCollections.observableArrayList(FloresDAO.listar()));
            FloresLimparCampos();
        } catch (Exception e) {
        }
    }

    private void FloresLimparCampos() {
        txtFloresNome.setText("");
        txtFloresCor.setText("");
        txtFloresTipo.setText("");
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

    private KpopSingers cantoraSelecionada;

    @FXML
    private TableView<KpopSingers> tableKpop;

    @FXML
    private TableColumn<KpopSingers, String> KpopNomeColumn;
    @FXML
    private TableColumn<KpopSingers, Integer> KpopIdadeColumn;
    @FXML
    private TableColumn<KpopSingers, String> KpopGrupoColumn;

    @FXML
    public void tbSelectedKpop() {
        KpopNomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        KpopIdadeColumn.setCellValueFactory(new PropertyValueFactory<>("idade"));
        KpopGrupoColumn.setCellValueFactory(new PropertyValueFactory<>("grupo"));

        KpopPreencherTableView();
    }

    @FXML
    private void KpopCriar() {
        try {
            String nome = txtKpopNome.getText();
            int idade = Integer.parseInt(txtKpopIdade.getText());
            String grupo = txtKpopGrupo.getText();

            KpopSingers cantora = new KpopSingers(nome, idade, grupo);
            KpopSingersDAO.inserir(cantora);
            mbox.ShowMessageBox("Cantora K-Pop", "Cantora cadastrada com sucesso");
            KpopPreencherTableView();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void KpopEditar() {
        try {
            String nome = txtKpopNome.getText();
            int idade = Integer.parseInt(txtKpopIdade.getText());
            String grupo = txtKpopGrupo.getText();

            KpopSingers cantora = new KpopSingers(cantoraSelecionada.getId(), nome, idade, grupo);
            KpopSingersDAO.inserir(cantora);
            mbox.ShowMessageBox("Cantora K-Pop", "Cantora cadastrada com sucesso");
            KpopPreencherTableView();
        } catch (Exception e) {
        }
    }

    @FXML
    private void KpopExcluir() {
        try {
            KpopSingersDAO.excluir(cantoraSelecionada.getId());
            mbox.ShowMessageBox("Kpop", "Kpop excluida com sucesso");
            KpopPreencherTableView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void KpopCantar() {
        try {
            String title = cantoraSelecionada.Cantar();
            String gifPath = getClass().getResource("/gifs/kpop-cantar.gif").toExternalForm();
            mbox.ShowGifMessageBox(title, gifPath);
        } catch (Exception e) {
        }
    }

    @FXML
    private void KpopDancar() {
        try {
            String title = cantoraSelecionada.Dancar();
            String gifPath = getClass().getResource("/gifs/kpop-dancar.gif").toExternalForm();
            mbox.ShowGifMessageBox(title, gifPath);
        } catch (Exception e) {
        }
    }

    @FXML
    private void KpopClickTableView() {
        KpopLimparCampos();
        cantoraSelecionada = tableKpop.getSelectionModel().getSelectedItem();
        txtKpopNome.setText(cantoraSelecionada.getNome());
        txtKpopIdade.setText(String.valueOf(cantoraSelecionada.getIdade()));
        txtKpopGrupo.setText(String.valueOf(cantoraSelecionada.getGrupo()));
    }

    @FXML
    private void KpopPreencherTableView() {
        try {
            tableKpop.setItems(FXCollections.observableArrayList(KpopSingersDAO.listar()));
            KpopLimparCampos();
        } catch (Exception e) {
        }
    }

    private void KpopLimparCampos() {
        txtKpopNome.setText("");
        txtKpopIdade.setText("");
        txtKpopGrupo.setText("");
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

    private TiposDeCabelo cabeloSelecionado;

    @FXML
    private TableView<TiposDeCabelo> tableCabelo;

    @FXML
    private TableColumn<TiposDeCabelo, String> CabeloTipoColumn;
    @FXML
    private TableColumn<TiposDeCabelo, String> CabeloCorColumn;
    @FXML
    private TableColumn<TiposDeCabelo, String> CabeloComprimentoColumn;
    @FXML
    private TableColumn<TiposDeCabelo, Boolean> CabeloNaturalColumn;

    @FXML
    public void tbSelectedCabelo() {
        CabeloTipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        CabeloCorColumn.setCellValueFactory(new PropertyValueFactory<>("cor"));
        CabeloComprimentoColumn.setCellValueFactory(new PropertyValueFactory<>("comprimento"));
        CabeloNaturalColumn.setCellValueFactory(new PropertyValueFactory<>("isNatural"));

        CabeloNaturalColumn.setCellFactory(column -> new TableCell<TiposDeCabelo, Boolean>() {
            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item ? "Sim" : "Não");
                }
            }
        });

        CabeloPreencherTableView();
    }

    @FXML
    private void CabeloCriar() {
        try {
            String tipo = txtCabeloTipo.getText();
            String cor = txtCabeloCor.getText();
            double comprimento = Double.parseDouble(txtCabeloComprim.getText());
            boolean natural = chkCabeloNatural.isSelected();

            TiposDeCabelo cabelo = new TiposDeCabelo(tipo, cor, comprimento, natural);
            TiposDeCabeloDAO.inserir(cabelo);
            mbox.ShowMessageBox("Cabelos", "Cabelo cadastrado com sucesso");
            CabeloPreencherTableView();
        } catch (Exception e) {
        }
    }

    @FXML
    private void CabeloEditar() {
        try {
            String tipo = txtCabeloTipo.getText();
            String cor = txtCabeloCor.getText();
            double comprimento = Double.parseDouble(txtCabeloComprim.getText());
            boolean natural = chkCabeloNatural.isSelected();

            TiposDeCabelo cabelo = new TiposDeCabelo(cabeloSelecionado.getId(), tipo, cor, comprimento, natural);
            TiposDeCabeloDAO.atualizar(cabelo);
            mbox.ShowMessageBox("Cabelos", "Cabelo Editado com sucesso");
            CabeloPreencherTableView();
        } catch (Exception e) {
        }
    }

    @FXML
    private void CabeloExcluir() {
        try {
            TiposDeCabeloDAO.excluir(cabeloSelecionado.getId());
            mbox.ShowMessageBox("Cabelos", "Cabelo excluido com sucesso");
            CabeloPreencherTableView();
        } catch (Exception e) {
        }
    }

    @FXML
    private void CabeloCortar() {
        try {
            String title = cabeloSelecionado.Cortar();
            String gifPath = getClass().getResource("/gifs/cabelo-cortar.gif").toExternalForm();
            mbox.ShowGifMessageBox(title, gifPath);
        } catch (Exception e) {
        }
    }

    @FXML
    private void CabeloPentear() {
        try {
            String title = cabeloSelecionado.Pentear();
            String gifPath = getClass().getResource("/gifs/cabelo-pentear.gif").toExternalForm();
            mbox.ShowGifMessageBox(title, gifPath);
        } catch (Exception e) {
        }
    }

    @FXML
    private void CabeloClickTableView() {
        CabeloLimparCampos();
        cabeloSelecionado = tableCabelo.getSelectionModel().getSelectedItem();
        txtCabeloTipo.setText(cabeloSelecionado.getTipo());
        txtCabeloCor.setText(String.valueOf(cabeloSelecionado.getCor()));
        txtCabeloComprim.setText(String.valueOf(cabeloSelecionado.getComprimento()));
        chkCabeloNatural.setSelected(cabeloSelecionado.isNatural());
    }

    private void CabeloPreencherTableView() {
        try {
            tableCabelo.setItems(FXCollections.observableArrayList(TiposDeCabeloDAO.listar()));
            CabeloLimparCampos();
        } catch (Exception e) {
        }
    }

    private void CabeloLimparCampos() {
        txtCabeloTipo.setText("");
        txtCabeloCor.setText("");
        txtCabeloComprim.setText("");
        chkCabeloNatural.setSelected(false);
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

        // cachorro = new Cachorro(nome, raca, peso, idade);
        CachorroDAO dao = new CachorroDAO();
        dao.inserir(cachorro);
        mbox.ShowMessageBox("Cachorro", "Cachorro cadastrado com sucesso");
    }

    @FXML
    private void CachorroVerCadastro() {
        String message = "Nome: " + cachorro.getNome()
                + "\nRaça: " + cachorro.getRaca()
                + "\nPeso: " + cachorro.getPeso()
                + "\nIdade: " + cachorro.getIdade();
        mbox.ShowMessageBox("Cadastro do Cachorro", message);
    }

    @FXML
    private void CachorroCorrer() {
        String title = cachorro.Correr();
        String gifPath = getClass().getResource("/gifs/cachorro-correr.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    @FXML
    private void CachorroLatir() {
        String title = cachorro.Latir();
        String gifPath = getClass().getResource("/gifs/cachorro-latir.gif").toExternalForm();
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

        // planeta = new Planeta(nome, massa, diametro, distSol, temAnel);
        PlanetaDAO dao = new PlanetaDAO();
        dao.inserir(planeta);
        mbox.ShowMessageBox("Planeta", "Planeta cadastrado com sucesso");
    }

    @FXML
    private void PlanetaGirar() {
        String title = planeta.Girar();
        String gifPath = getClass().getResource("/gifs/planeta-girar.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    @FXML
    private void PlanetaOrbitar() {
        String title = planeta.Orbitar();
        String gifPath = getClass().getResource("/gifs/planeta-orbitar.gif").toExternalForm();
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
        RefrigeranteDAO dao = new RefrigeranteDAO();
        dao.inserir(refrigerante);
        mbox.ShowMessageBox("Refrigerante", "Refrigerante cadastrado com sucesso");
    }

    @FXML
    private void RefriVerCadastro() {
        String message = "Nome: " + refrigerante.getNome()
                + "\nSabor: " + refrigerante.getSabor()
                + "\nMarca: " + refrigerante.getMarca()
                + "\nVolume: " + refrigerante.getVolumeML()
                + "\nÉ diet: " + (refrigerante.isDiet() ? "Sim" : "Não");
        mbox.ShowMessageBox("Cadastro do Refrigerante", message);
    }

    @FXML
    private void RefriAbrir() {
        String title = refrigerante.Abrir();
        String gifPath = getClass().getResource("/gifs/refri-abrir.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
        estaAberto = true;
    }

    @FXML
    private void RefriServir() {
        if (estaAberto == false) {
            mbox.ShowMessageBox("Refrigerante", "Refrigerante está fechado");
            return;
        }
        String title = refrigerante.Servir();
        String gifPath = getClass().getResource("/gifs/refri-servir.gif").toExternalForm();
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
        SanrioDAO dao = new SanrioDAO();
        dao.inserir(personagemSanrio);
        mbox.ShowMessageBox("Personagem Sanrio", "Personagem cadastrado com sucesso");
    }

    @FXML
    private void SanrioVerCadastro() {
        String message = "Nome: " + personagemSanrio.getNome()
                + "\nComida Favorita: " + personagemSanrio.getComidaFav()
                + "\nCor: " + personagemSanrio.getCor()
                + "\nIdade: " + personagemSanrio.getIdade();
        mbox.ShowMessageBox("Cadastro do Personagem Sanrio", message);
    }

    @FXML
    private void SanrioBrincar() {
        String title = personagemSanrio.Brincar();
        String gifPath = getClass().getResource("/gifs/sanrio-brincar.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    @FXML
    private void SanrioCozinhar() {
        String title = personagemSanrio.Cozinhar();
        String gifPath = getClass().getResource("/gifs/sanrio-cozinhar.gif").toExternalForm();
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
        JogadorasDeVoleiDAO dao = new JogadorasDeVoleiDAO();
        dao.inserir(jogadora);
        mbox.ShowMessageBox("Jogadora de Vôlei", "Jogadora cadastrada com sucesso");
    }

    @FXML
    private void VoleiVerCadastro() {
        String message = "Nome: " + jogadora.getNome()
                + "\nPosição: " + jogadora.getPosicao()
                + "\nAltura: " + jogadora.getAltura()
                + "\nNúmero: " + jogadora.getNumeroCamisa();
        mbox.ShowMessageBox("Cadastro da Jogadora de Vôlei", message);
    }

    @FXML
    private void VoleiAtacar() {
        String title = jogadora.Atacar();
        String gifPath = getClass().getResource("/gifs/volei-atacar.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    @FXML
    private void VoleiSacar() {
        String title = jogadora.Sacar();
        String gifPath = getClass().getResource("/gifs/volei-sacar.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    @FXML
    private void VoleiBloquear() {
        String title = jogadora.Bloquear();
        String gifPath = getClass().getResource("/gifs/volei-bloquear.gif").toExternalForm();
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
        TrabalhadoresDeEscritorioDAO dao;
        dao = new TrabalhadoresDeEscritorioDAO();
        dao.inserir(escritorio);
        mbox.ShowMessageBox("Escritório", "Cadastro realizado com sucesso");
    }

    @FXML
    private void OfficeVerCadastro() {
        String message = "Nome: " + escritorio.getNome()
                + "\nSalário: " + escritorio.getSalario()
                + "\nCargo: " + escritorio.getCargo();
        mbox.ShowMessageBox("Cadastro do Escritório", message);
    }

    @FXML
    private void OfficeTrabalhar() {
        String title = escritorio.Trabalhar();
        String gifPath = getClass().getResource("/gifs/office-trabalhar.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    @FXML
    private void OfficeReuniao() {
        String title = escritorio.ParticiparDeReuniao();
        String gifPath = getClass().getResource("/gifs/office-reuniao.gif").toExternalForm();
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
        SalgadinhosDAO dao = new SalgadinhosDAO();
        dao.inserir(salgadinho);
        mbox.ShowMessageBox("Salgadinho", "Salgadinho criado com sucesso");
    }

    @FXML
    private void SalgadVerCadastro() {
        String message = "Sabor: " + salgadinho.getSabor()
                + "\nPeso: " + salgadinho.getPeso()
                + "\nQuantidade: " + salgadinho.getQtnde();
        mbox.ShowMessageBox("Cadastro do Salgadinho", message);
    }

    @FXML
    private void SalgadComer() {
        String title = salgadinho.Comer();
        if (title == null) {
            mbox.ShowMessageBox("Salgadinho", "Você não tem salgadinho para comer");
            return;
        }
        String gifPath = getClass().getResource("/gifs/salgad-comer.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    @FXML
    private void SalgadAdd() {
        String title = salgadinho.Add();
        String gifPath = getClass().getResource("/gifs/salgad-add.gif").toExternalForm();
        mbox.ShowGifMessageBox(title, gifPath);
    }

    // #endregion Salgadinho
}
