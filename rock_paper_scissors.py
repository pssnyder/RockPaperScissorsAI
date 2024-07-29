import random

class RockPaperScissorsAI:
    def __init__(self):
        self.history = []

    def choose_action(self):
        if not self.history:
            return random.choice(['rock', 'paper', 'scissors'])
        
        # Simple prediction based on the opponent's last move
        last_move = self.history[-1]['opponent']
        if last_move == 'rock':
            return 'paper'
        elif last_move == 'paper':
            return 'scissors'
        else:
            return 'rock'

    def record_result(self, opponent_move, result):
        self.history.append({'opponent': opponent_move, 'result': result})