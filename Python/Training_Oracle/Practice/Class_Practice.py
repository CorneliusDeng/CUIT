class Image:
    tongdao = ""
    type_tongdao = ""
    address = ""
    color = ""
    size = 1

    def __init__(self, tongdao, type_tongdao, address, color, size):
        self.tongdao = tongdao
        self.type_tongdao = type_tongdao
        self.address = address
        self.color = color
        self.size = size

    def __del__(self):
        print("删除")

    def get_tongdao(self):
        return self.tongdao
    def set_tongdao(self, tongdao):
        self.tongdao = tongdao



