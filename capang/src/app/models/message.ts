export class Message {

  playersCard: string;
  aiCard: string;
  outcome: string;

  public Message(playersCard: string, aiCard: string, outcome: string) {
    this.aiCard = aiCard;
    this.playersCard = playersCard;
    this.outcome = outcome;
  }
}
