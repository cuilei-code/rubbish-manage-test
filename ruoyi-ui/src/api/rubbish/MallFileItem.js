import request from '@/utils/request'

// 查询积分商城文件列表
export function listMallFileItem(query) {
  return request({
    url: '/rubbish/MallFileItem/list',
    method: 'get',
    params: query
  })
}

// 查询积分商城文件详细
export function getMallFileItem(id) {
  return request({
    url: '/rubbish/MallFileItem/' + id,
    method: 'get'
  })
}

// 新增积分商城文件
export function addMallFileItem(data) {
  return request({
    url: '/rubbish/MallFileItem',
    method: 'post',
    data: data
  })
}

// 修改积分商城文件
export function updateMallFileItem(data) {
  return request({
    url: '/rubbish/MallFileItem',
    method: 'put',
    data: data
  })
}

// 删除积分商城文件
export function delMallFileItem(id) {
  return request({
    url: '/rubbish/MallFileItem/' + id,
    method: 'delete'
  })
}
