from fastapi import APIRouter
import random

request_receiver = APIRouter()

@request_receiver.get("/request-data")
async def receive_spring_data():
    print("Receive Spring Data!")
    ready_asset = { 'name': 'Hi', 'major': 'C' }
    return ready_asset

@request_receiver.get("/request-int-data")
async def request_integer_process():
    return random.randrange(10,21)

# 아래 두 개는 과제
@request_receiver.get("/request-second-data")
async def request_second_number_process():
    return random.randrange(1,10)

@request_receiver.get("/request-third-data")
async def request_second_number_process():
    return random.randrange(1,10)

@request_receiver.get('/integer-request')
async def integer_request_receiver():
    return random.randrange(15, 21)