/* Trabalho Pr�tico - Sistema de Administra��o de Vendas de M�scaras
*  Programadores: Matheus Ryuji Matsutane
*  Cria��o: 09/12/2020 | �ltima atualiza��o: 15/12/2020
*  */


package ApplicationStore;

// Declara��o da classe Mask (M�scaras)
// Define id (identifica��o), descri��o (description),
// estoque (stock), vendas di�rias (dailySale),
// pre�o de produ��o (productionPrice) e pre�o de vendas
// (salePrice).

class Mask {
	
    private int id;
    private String description;
    
    private int stock;
    private int dailySale;
    
    private float productionPrice;
    private float salePrice;
    
    // M�TODO Mask - M�scara (mask)
    // Recebe e armazena o ID, descri��o, pre�o de produ��o e
    // pre�o de vendas de cada objeto do tipo m�scara
    
    public Mask(int id, String description, float productionPrice, float salePrice){
        this.id = id;
        this.stock = 0;
        this.dailySale = 0;
        setProductionPrice(productionPrice);
        setSalePrice(salePrice);
        this.description = description;
    }
    
    // M�TODO registerDailySale
    // Verifica se a quantidade � maior que 0, registra as
    // vendas (aumenta as vendas e diminui estoque), informa
    // o sucesso da opera��o.
    // Se venda > estoque, imprime mensagem de erro.
    
    public String registerDailySale(int quantity){
        if(quantity < 1){
            return "Quantidade deve ser maior que 0.";
        }
        
        if(stock - quantity >= 0){
            dailySale += quantity;
            stock -= quantity;
            return "Venda registrada com sucesso.";
        } else {
            return "N�o � poss�vel vender uma quantidade maior que a em estoque.";
        } 
    }
    
    // M�TODO getDailySale
    // Retorna a quantidade vendida no dia
    
    public int getDailySale(){
        return dailySale;
    }
    
    // M�TODO setDailyStock
    // Atualiza o estoque baseado na quantidade
    // fornecida como par�metro, originada pelo usu�rio.
    
    public String setDailyStock(int quantity){
        if(quantity > 0){
            stock = quantity;
            return "Estoque atualizado com sucesso.";
        } else {
            return "Quantidade deve ser maior que 0.";
        }
    }
    
    // M�TODO getDailyStock
    // Retorna a quantidade de estoque no dia
    
    public int getDailyStock(){
        return stock;
    }
    
    // M�TODO setProductionPrice
    // Verifica se o custo de produ��o � maior que zero,
    // e ent�o atualiza-o (ap�s receber do usu�rio).
    
    public String setProductionPrice(float price){
        if(price >= 0){
            this.productionPrice = price;
            return "Pre�o de produ��o atualizado com sucesso.";
        } else {
            return "Pre�o de produ��o deve ser maior que 0.";
        }
    }
    
    // M�TODO getProductionPrice
    // Retorna o custo de produ��o
    
    public float getProductionPrice(){
        return productionPrice;
    }
    
    // M�TODO setSalePrice
    // Verifica se o pre�o de venda � maior que zero,
    // e ent�o atualiza-o (ap�s receber do usu�rio).
    
    public String setSalePrice(float price){
        if(price >= 0){
            this.salePrice = price;
            return "Pre�o de venda atualizado com sucesso.";
        } else {
            return "Pre�o de venda deve ser maior que 0.";
        }
    }
    
    // M�TODO getSalePrice
    // Retorna o pre�o de vendas
    
    public float getSalePrice() {
        return salePrice;
    }
    
    // M�TODO getDescription
    // Retorna a descri��o do produto
    
    public String getDescription(){
        return description;
    }
}

/* Trabalho Pr�tico - Sistema de Administra��o de Vendas de M�scaras
*  Programadores: Matheus Ryuji Matsutane
*  Cria��o: 09/12/2020 | �ltima atualiza��o: 15/12/2020
*  */